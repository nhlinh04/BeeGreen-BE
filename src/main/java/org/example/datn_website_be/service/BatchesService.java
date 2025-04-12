package org.example.datn_website_be.service;

import org.example.datn_website_be.Enum.Status;
import org.example.datn_website_be.dto.request.BatchesRequest;
import org.example.datn_website_be.dto.response.BatchesBillRespnse;
import org.example.datn_website_be.model.*;
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
    public void findByHSD() {
        List<Batches> batchesList = batchesRepository.findByHSD();
        System.out.println("check HSD");
        System.out.println(batchesList.size());
        if (!batchesList.isEmpty()) {
            System.out.println("HSD");
            for (Batches batches : batchesList){
                System.out.println(batches.getProduct().getName());
                Product product = productRepository.findById(batches.getProduct().getId())
                                .orElseThrow(() -> new RuntimeException("Sản phẩm không tồn tại!"));
                product.setQuantity(new BigDecimal(product.getQuantity() - batches.getQuantity()).max(BigDecimal.ZERO).setScale(2, RoundingMode.FLOOR).doubleValue());
                ProductHistory productHistory = ProductHistory.builder()
                        .note(
                                (new BigDecimal(batches.getQuantity()).setScale(2, RoundingMode.CEILING).doubleValue()) +
                                        " " +
                                        product.getBaseUnit() + " hủy do đã hết hạn"
                        )
                        .product(product)
                        .build();
                batches.setQuantity(0.0);
                batchesRepository.save(batches);
                productRepository.save(product);

                productHistoryRepository.save(productHistory);
            }
        }
    }

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
        product.setQuantity(new BigDecimal(product.getQuantity() + batchesRequest.getQuantity()).setScale(2, RoundingMode.CEILING).max(BigDecimal.ZERO).doubleValue());

        productRepository.save(product);
        batchesRepository.save(batches);
        Account account = accountService.getUseLogin();
        ProductHistory productHistory = ProductHistory.builder()
                .note(account.getEmail() + " đã thêm " +
                        (new BigDecimal(batchesRequest.getQuantity()).setScale(2, RoundingMode.CEILING).max(BigDecimal.ZERO).doubleValue()) +
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
                batches.setQuantity(new BigDecimal(availableQuantity - quantity).setScale(2, RoundingMode.FLOOR).max(BigDecimal.ZERO).doubleValue());
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
            batches.setQuantity(new BigDecimal(batches.getQuantity() + batchesBillRespnse.getQuantityBillDetailBatches()).setScale(2, RoundingMode.CEILING).max(BigDecimal.ZERO).doubleValue());
            batchesRepository.save(batches);
        }
    }
    @Transactional
    public void ExportProductBatches(double quantity,String codeBatches){
        Batches batches = batchesRepository.findByCode(codeBatches);
        if (quantity>batches.getQuantity()){
            throw new RuntimeException("Số lượng hủy vượt quá số lượng còn lại trong lô sản phẩm");
        }
        batches.setQuantity(batches.getQuantity()-quantity);
        batchesRepository.save(batches);
    }

    @Transactional
    public List<Batches> findBatchesByIdProduct(Long idProduct){
        return batchesRepository.findByProductId(idProduct);
    }
}
