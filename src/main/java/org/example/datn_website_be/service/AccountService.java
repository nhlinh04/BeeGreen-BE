
package org.example.datn_website_be.service;


import org.example.datn_website_be.Enum.Role;
import org.example.datn_website_be.Enum.Status;
import org.example.datn_website_be.dto.accountWithPassword.AccountWithPassword;
import org.example.datn_website_be.dto.request.*;
import org.example.datn_website_be.dto.response.AccountResponse;
import org.example.datn_website_be.model.Account;
import org.example.datn_website_be.repository.AccountRepository;
import org.example.datn_website_be.repository.AccountVoucherRepository;
import org.example.datn_website_be.webconfig.AccountLockedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
     AddressService addressService;
    @Autowired
    AccountVoucherRepository accountVoucherRepository;
    @Autowired
     EmailService emailService;
    @Autowired
     RandomPasswordGeneratorService randomPassword;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private String htmlTemplate = """
    <!DOCTYPE html>
    <html lang="vi">
    <head>
    <meta charset="UTF-8" />
    <title>Chào mừng đến với GreenFarm</title>
    <style>
        body {font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f0f4f8; margin:0; padding:0; color:#2e3a2f;}
        .container {max-width:600px; margin:30px auto; background:white; border-radius:12px; box-shadow:0 6px 18px rgba(50, 50, 93, 0.1); overflow:hidden;}
        .header {background: linear-gradient(90deg, #4caf50 0%%, #ff9800 50%%, #673ab7 100%%); padding:20px; text-align:center; color:white; font-size:26px; font-weight:700;}
        .banner-img {width:100%%; display:block; border-bottom:4px solid #4caf50;}
        .content {padding:30px 35px; line-height:1.6; font-size:16px;}
        .content p {margin:15px 0;}
        ul {list-style-type:none; padding-left:0;}
        li {font-weight:600; margin-bottom:8px;}
        .btn {display:inline-block; background:#2e7d32; color:white !important; padding:12px 28px; margin:25px 0; border-radius:8px; text-decoration:none; font-weight:600; font-size:16px;}
        .btn:hover {background:#1b4d20;}
        .footer {font-size:14px; color:#555; text-align:center; padding:20px; background:#f9f9f9;}
        a {color:#673ab7; text-decoration:none;}
        a:hover {text-decoration:underline;}
    </style>
    </head>
    <body>
        <div class="container">
            <div class="header">Chào mừng bạn đến với GreenFarm!</div>
            <img class="banner-img" src="https://img.pikbest.com/origin/06/06/45/807pIkbEsTePT.jpg!w700wp" alt="GreenFarm Rau củ tươi sạch" />
            <div class="content">
                <p>Kính chào Quý khách hàng,</p>
                <p>Cảm ơn bạn đã đăng ký tài khoản tại <strong>GreenFarm</strong> – nơi cung cấp rau xanh tươi sạch, an toàn và đa dạng.</p>
                <p>Thông tin tài khoản của bạn:</p>
                <ul>
                    <li>Tên tài khoản: <strong>%s</strong></li>
                    <li>Mật khẩu: <strong>%s</strong></li>
                </ul>
                <a href="http://localhost:3000/login" class="btn" target="_blank" rel="noopener">Đăng nhập ngay</a>
                <p>Nếu bạn có thắc mắc hoặc cần hỗ trợ, vui lòng liên hệ với chúng tôi qua email <a href="mailto:linhnhph33830@fpt.edu.vn">linhnhph33830@fpt.edu.vn</a> hoặc điện thoại <strong>0909 123 456</strong>.</p>
                <p>Chúc bạn một ngày thật nhiều sức khỏe và niềm vui với rau xanh từ GreenFarm!</p>
                <p>Trân trọng,<br />Đội ngũ GreenFarm</p>
            </div>
            <div class="footer">© 2025 GreenFarm. Bản quyền thuộc về GreenFarm.</div>
        </div>
    </body>
    </html>
    """;



    public void createAccount(AccountRequest accountRequest) {
        Optional<Account> accountOP = accountRepository.findByEmail(accountRequest.getEmail());
        if (accountOP.isPresent()) {
            throw new RuntimeException("Email " + accountRequest.getEmail() + " đã tồn tại trong hệ thống. Vui lòng sử dụng email khác.");
        }
        AccountWithPassword accountWithPassword = convertAccountRequestDTO(accountRequest);
        Account account = accountRepository.save(accountWithPassword.getAccount());
        if (account != null) {
            String password = accountWithPassword.getPassword();
            String email = account.getEmail();

            // Tạo nội dung HTML email với thông tin tài khoản
            String emailContent = String.format(htmlTemplate, email, password);

            // Gửi email với nội dung HTML
            emailService.sendRegisterEmail(email, "Chào mừng bạn đến với GreenFarm!", emailContent); // true = gửi HTML

        } else {
            throw new RuntimeException("Lỗi thêm tài khoản mới!");
        }
    }

    public void createAccountEmployee(EmployeeCreationRequest employeeCreationRequest) {
        Optional<Account> accountOP = accountRepository.findByEmail(employeeCreationRequest.getAccountRequest().getEmail());
        if (accountOP.isPresent()) {
            throw new RuntimeException("Email " + employeeCreationRequest.getAccountRequest().getEmail() + " đã tồn tại trong hệ thống. Vui lòng sử dụng email khác.");
        }

        AccountWithPassword accountWithPassword = convertAccountRequestDTO(employeeCreationRequest.getAccountRequest());
        Account account = accountRepository.save(accountWithPassword.getAccount());

        if (account != null) {
            String password = accountWithPassword.getPassword();
            String email = account.getEmail();

            String emailContent = String.format(
                    "Kính chào Quý khách hàng,%n" +
                            "Chào mừng bạn đến với %s!%n" +
                            "Thông tin tài khoản của bạn như sau:%n" +
                            "• Tên tài khoản: %s%n" +
                            "• Mật khẩu: %s%n" +
                            "Nếu bạn có bất kỳ câu hỏi nào hoặc cần hỗ trợ, vui lòng liên hệ với chúng tôi qua email %s hoặc số điện thoại %s.%n%n" +
                            "Trân trọng,%n%s",
                    "Greenbee",
                    email,
                    password,
                    "linhnhph33830@fpt.edu.vn",
                    "0909 123 456",
                    "Greenbee"
            );

            emailService.sendEmail(
                    email,
                    "Chào mừng bạn đến với GreenBee!",
                    emailContent
            );

            AddressRequest addressRequest = AddressRequest.builder()
                    .idAccount(account.getId())
                    .codeCity(employeeCreationRequest.getAddressRequest().getCodeCity())
                    .codeDistrict(employeeCreationRequest.getAddressRequest().getCodeDistrict())
                    .codeWard(employeeCreationRequest.getAddressRequest().getCodeWard())
                    .address(employeeCreationRequest.getAddressRequest().getAddress())
                    .build();
            addressService.createAddress(addressRequest);

        } else {
            throw new RuntimeException("Lỗi thêm tài khoản mới!");
        }
    }


    public void updateAccountEmployee(Long idAccount, Long idAddress, EmployeeUpdateRequest employeeUpdateRequest) {
        Account account = accountRepository.findById(idAccount).orElseGet(() -> {
            throw new RuntimeException("Tài khoản không tồn tại");
        });
        account.setName(employeeUpdateRequest.getAccountRequest().getName());
        account.setPhoneNumber(employeeUpdateRequest.getAccountRequest().getPhoneNumber());
        account.setGender(employeeUpdateRequest.getAccountRequest().getGender());
        account.setBirthday(employeeUpdateRequest.getAccountRequest().getBirthday());
        Account UpdateAccount = accountRepository.save(account);
        if (UpdateAccount != null) {
            AddressRequest addressRequest = AddressRequest.builder()
                    .idAccount(account.getId())
                    .codeCity(employeeUpdateRequest.getAddressRequest().getCodeCity())
                    .codeDistrict(employeeUpdateRequest.getAddressRequest().getCodeDistrict())
                    .codeWard(employeeUpdateRequest.getAddressRequest().getCodeWard())
                    .address(employeeUpdateRequest.getAddressRequest().getAddress())
                    .build();
            addressService.updateAddress(idAddress, addressRequest);
        } else {
            throw new RuntimeException("Lỗi cập nhật tài khoản !");
        }
    }

    public void updateAccount(Long idAccount, AccountUpdateRequest accountRequest) {
        Account account = accountRepository.findById(idAccount).orElseGet(() -> {
            throw new RuntimeException("Tài khoản không tồn tại");
        });
        account.setName(accountRequest.getName());
        account.setPhoneNumber(accountRequest.getPhoneNumber());
        account.setGender(accountRequest.getGender());
        account.setBirthday(accountRequest.getBirthday());
        accountRepository.save(account);
    }

    public void updateStatus(Long idAccount, boolean aBoolean) {
        Optional<Account> accountOt = accountRepository.findById(idAccount);
        if (!accountOt.isPresent()) {
            throw new RuntimeException("Id " + accountOt.get().getId() + " của tài khoản không tồn tại");
        }
        String newStatus = aBoolean ? Status.ACTIVE.toString() : Status.INACTIVE.toString();
        accountOt.get().setStatus(newStatus);
        accountRepository.save(accountOt.get());
    }

    public List<AccountResponse> getAllAccountCustomerActive() {
        return accountRepository.listCustomerResponseByStatus(Role.CUSTOMER.toString());
    }

    public AccountResponse findAccountById(Long idAccount) {
        Optional<Account> accountOP = accountRepository.findById(idAccount);
        if (!accountOP.isPresent()) {
            throw new RuntimeException("Đối tượng không tồn tại .");
        }
        AccountResponse accountResponse = AccountResponse.builder()
                .id(accountOP.get().getId())
                .name(accountOP.get().getName())
                .email(accountOP.get().getEmail())
                .phoneNumber(accountOP.get().getPhoneNumber())
                .role(accountOP.get().getRole())
                .gender(accountOP.get().getGender())
                .birthday(accountOP.get().getBirthday())
                .rewards(accountOP.get().getRewards())
                .status(accountOP.get().getStatus())
                .build();
        return accountResponse;
    }

    public List<AccountResponse> getAllAccountEmployeeActive() {
        return accountRepository.listEmployeeResponseByStatus(Role.EMPLOYEE.toString());
    }

    public AccountWithPassword convertAccountRequestDTO(AccountRequest accountRequest) {
        String password = randomPassword.getPassword();
        Account account = Account.builder()
                .name(accountRequest.getName())
                .email(accountRequest.getEmail())
                .phoneNumber(accountRequest.getPhoneNumber())
                .password(passwordEncoder.encode(password))
                .role(accountRequest.getRole())
                .gender(accountRequest.getGender())
                .birthday(accountRequest.getBirthday())
                .rewards(0)
                .build();
        account.setStatus(accountRequest.getStatus());
        return new AccountWithPassword(account, password);
    }

    public List<String> findEmailsByCustomerIds(List<Long> customerIds) {
        if (customerIds == null || customerIds.isEmpty()) {
            throw new IllegalArgumentException("Customer IDs list cannot be empty.");
        }
        return accountRepository.findEmailsByCustomerIds(customerIds);
    }

    public Account getUseLogin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Tìm kiếm tài khoản bằng email
        Account account = accountRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy địa chỉ Email: " + authentication.getName()));

        // Kiểm tra xem tài khoản có bị khóa không
        if (!account.isAccountNonLocked()) {
            throw new AccountLockedException("Tài khoản đã bị khóa!");
        }

        return account;
    }


}

