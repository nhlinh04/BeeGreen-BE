package org.example.datn_website_be.scheduler;

import lombok.RequiredArgsConstructor;
import org.example.datn_website_be.model.BatchDiscountRule;
import org.example.datn_website_be.model.Batches;
import org.example.datn_website_be.model.Product;
import org.example.datn_website_be.model.Promotion;
import org.example.datn_website_be.repository.BatchDiscountRuleRepository;
import org.example.datn_website_be.repository.BatchesRepository;
import org.example.datn_website_be.repository.PromotionRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Component
@RequiredArgsConstructor
public class BatchDiscountScheduler {

    private final BatchesRepository batchRepository;
    private final PromotionRepository promotionRepository;
    private final BatchDiscountRuleRepository ruleRepository;

    @Scheduled(cron = "0 0 0 * * *")
    public void applyBatchDiscounts() {
        // Lấy tất cả các batch có còn hạn và có quantity > 0
        List<Batches> batches = batchRepository.findByHSDGreaterThanEqualAndQuantityGreaterThan(new Date(), 0.0);
        List<BatchDiscountRule> rules = ruleRepository.findByStatus("ACTIVE");
        LocalDateTime now = LocalDateTime.now();

        for (Batches batch : batches) {
            // Lấy discount promotion hiện tại
            Integer promotionDiscount = getCurrentPromotionDiscount(batch.getProduct()); // Promotion discount kiểu Integer

            // Tính số ngày còn lại cho mỗi batch
            LocalDateTime expiryDate = batch.getHSD().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            long daysToExpire = ChronoUnit.DAYS.between(now, expiryDate);

            // Tìm rule khuyến mãi tương ứng với batch
            Optional<BatchDiscountRule> matchedRule = rules.stream()
                    .filter(r -> daysToExpire <= r.getDaysBeforeExpiry()).min(Comparator.comparing(BatchDiscountRule::getDaysBeforeExpiry));

            // Nếu tìm thấy rule khuyến mãi phù hợp
            matchedRule.ifPresent(rule -> {
                int batchDiscount = rule.getDiscountPercent(); // Batch discount kiểu Integer

                // Chọn discount cao nhất giữa batchDiscount và promotionDiscount
                int finalDiscount = Math.max(batchDiscount, promotionDiscount); // Chọn discount cao nhất

                // Tính giá sau khi áp dụng discount
                double pricePerBaseUnit = batch.getProduct().getPricePerBaseUnit().doubleValue(); // Lấy giá gốc của sản phẩm
                double discountMultiplier = 1 - ((double) finalDiscount / 100); // Chuyển discount thành tỷ lệ phần trăm (từ int hoặc double)

                double discountedPrice = pricePerBaseUnit * discountMultiplier; // Tính giá sau khi giảm giá

                // Làm tròn giá xuống 2 chữ số sau dấu thập phân
                discountedPrice = Math.round(discountedPrice * 100.0) / 100.0;

                // Cập nhật giá custom discount cho batch
                batch.setNearExpiryPrice(discountedPrice);
                batchRepository.save(batch);
            });
        }
    }


    private Integer getCurrentPromotionDiscount(Product product) {
        // Lấy tất cả các promotion liên quan đến sản phẩm
        List<Promotion> activePromotions = promotionRepository.findUpcomingDiscountsForProduct(LocalDateTime.now(), "ACTIVE", product.getId());

        // Nếu có chương trình promotion đang hoạt động
        if (!activePromotions.isEmpty()) {
            // Lấy chương trình promotion có discount lớn nhất (nếu có nhiều chương trình)
            Promotion currentPromotion = activePromotions.stream()
                    .max(Comparator.comparing(Promotion::getValue))
                    .orElse(null);

            return currentPromotion.getValue();
        }

        // Nếu không có promotion, trả về 0 (không giảm giá)
        return 0;
    }

}
