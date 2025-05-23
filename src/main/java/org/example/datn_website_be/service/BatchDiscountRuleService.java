package org.example.datn_website_be.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.datn_website_be.dto.request.BatchDiscountRuleRequest;
import org.example.datn_website_be.model.BatchDiscountRule;
import org.example.datn_website_be.repository.BatchDiscountRuleRepository;
import org.example.datn_website_be.scheduler.BatchDiscountScheduler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BatchDiscountRuleService {
    private final BatchDiscountRuleRepository batchDiscountRuleRepository;
    private final BatchDiscountScheduler batchDiscountScheduler;

    public BatchDiscountRule add(@Valid BatchDiscountRuleRequest request) {

        boolean exists = batchDiscountRuleRepository.existsByDaysBeforeExpiry(request.getDaysBeforeExpiry());
        if (exists) {
            throw new IllegalArgumentException("Đã tồn tại rule với số ngày trước hết hạn: " + request.getDaysBeforeExpiry());
        }

        BatchDiscountRule rule = BatchDiscountRule.builder()
                .daysBeforeExpiry(request.getDaysBeforeExpiry())
                .discountPercent(request.getDiscountPercent())
                .status(request.getStatus())
                .build();

        BatchDiscountRule save = batchDiscountRuleRepository.save(rule);
        batchDiscountScheduler.applyBatchDiscounts();

        return save;
    }

    public BatchDiscountRule update(Long id, BatchDiscountRuleRequest request) {
        BatchDiscountRule existing = batchDiscountRuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy rule với ID: " + id));

        // Nếu người dùng đổi daysBeforeExpiry, cần kiểm tra xem có trùng với rule khác không
        if (!(existing.getDaysBeforeExpiry() == request.getDaysBeforeExpiry())) {
            boolean duplicate = batchDiscountRuleRepository.existsByDaysBeforeExpiry(request.getDaysBeforeExpiry());
            if (duplicate) {
                throw new IllegalArgumentException("Đã tồn tại rule với số ngày trước hết hạn: " + request.getDaysBeforeExpiry());
            }
            existing.setDaysBeforeExpiry(request.getDaysBeforeExpiry());
        }

        existing.setDiscountPercent(request.getDiscountPercent());
        existing.setStatus(request.getStatus());

        BatchDiscountRule save = batchDiscountRuleRepository.save(existing);
        batchDiscountScheduler.applyBatchDiscounts();
        return save;

    }


    public List<BatchDiscountRule> listAll() {
        return batchDiscountRuleRepository.findAll();
    }

    public void updateStatus(Long id, Boolean newStatus) {
        BatchDiscountRule config = batchDiscountRuleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy cấu hình với ID: " + id));
        config.setStatus(newStatus ? "ACTIVE" : "INACTIVE");

        batchDiscountRuleRepository.save(config);
        batchDiscountScheduler.applyBatchDiscounts();
    }

    public BatchDiscountRule getById(Long id) {
        BatchDiscountRule config = batchDiscountRuleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy cấu hình với ID: " + id));
        return config;
    }
}
