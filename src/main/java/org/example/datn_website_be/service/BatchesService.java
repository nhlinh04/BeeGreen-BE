package org.example.datn_website_be.service;

import org.example.datn_website_be.Enum.Status;
import org.example.datn_website_be.dto.request.BatchesRequest;
import org.example.datn_website_be.dto.response.BatchesBillRespnse;
import org.example.datn_website_be.model.Account;
import org.example.datn_website_be.model.Batches;
import org.example.datn_website_be.model.Product;
import org.example.datn_website_be.model.ProductHistory;
import org.example.datn_website_be.repository.BatchesRepository;
import org.example.datn_website_be.repository.ProductHistoryRepository;
import org.example.datn_website_be.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class BatchesService {
    @Autowired
    BatchesRepository batchesRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    RandomPasswordGeneratorService randomPassword;
    @Autowired
    AccountService accountService;
    @Autowired
    public ProductHistoryRepository productHistoryRepository;

    @Transactional
    public void createBatches(BatchesRequest batchesRequest) {
        if (batchesRequest.getIdProduct() == null) {
            throw new RuntimeException("ID sản phẩm không được để trống");
        }
        Product product = productRepository.findById(batchesRequest.getIdProduct())
                .orElseThrow(() -> new RuntimeException("Sản phẩm với ID " + batchesRequest.getIdProduct() + "không tìm thấy!"));
        String code = "CODE" + randomPassword.getPassword();
        Batches batches = Batches.builder()
                .product(product)
                .quantity(batchesRequest.getQuantity())
                .NSX(batchesRequest.getNsx())
                .HSD(batchesRequest.getHsd())
                .code(code)
                .build();
        batches.setStatus(Status.ACTIVE.toString());
        product.setQuantity(new BigDecimal(product.getQuantity() + batchesRequest.getQuantity()).setScale(2, RoundingMode.CEILING).doubleValue());

        productRepository.save(product);
        batchesRepository.save(batches);
        Account account = accountService.getUseLogin();
        ProductHistory productHistory = ProductHistory.builder()
                .note(account.getEmail() + " đã thêm " +
                        (new BigDecimal(product.getQuantity() + batchesRequest.getQuantity()).setScale(2, RoundingMode.CEILING).doubleValue()) +
                        " " +
                        product.getBaseUnit() + " mới"
                )
                .account(account)
                .product(product)
                .build();
        productHistoryRepository.save(productHistory);
    }

    @Transactional
    public List<Batches> subtractBatches(Product product, double quantity) {
        List<Batches> batchesList = batchesRepository.findByProductAndStatus(product.getId(), Status.ACTIVE.toString());
        List<Batches> batchesArrayList = new ArrayList<>();
        if (batchesList.isEmpty()) {
            throw new IllegalArgumentException("Không có lô hàng nào khả dụng để cập nhật.");
        }

        int i = 0;
        while (quantity > 0 && i < batchesList.size()) {
            Batches batches = batchesList.get(i);
            double availableQuantity = batches.getQuantity();

            if (quantity >= availableQuantity) {
                quantity -= availableQuantity;
                batches.setQuantity(0.0);
            } else {
                batches.setQuantity(availableQuantity - quantity);
                quantity = 0; // Đã trừ hết số lượng cần giảm
            }
            batchesArrayList.add(batchesRepository.save(batches));
            i++; // Chuyển sang lô hàng tiếp theo
        }
        return batchesArrayList;
    }

    @Transactional
    public void plusBatches(Long idBillDetail, Long idProduct) {
        List<BatchesBillRespnse> batchesBillRespnseList = batchesRepository.findBatches(idProduct, idBillDetail);
        for (BatchesBillRespnse batchesBillRespnse : batchesBillRespnseList) {
            Batches batches = batchesRepository.findById(batchesBillRespnse.getIdBatches())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy lô sản phẩm"));
            batches.setQuantity(new BigDecimal(batches.getQuantity() + batchesBillRespnse.getQuantityBillDetailBatches()).setScale(2, RoundingMode.CEILING).doubleValue());
            batchesRepository.save(batches);
        }
    }
}
