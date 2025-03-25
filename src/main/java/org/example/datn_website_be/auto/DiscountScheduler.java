package org.example.datn_website_be.auto;


import org.example.datn_website_be.service.BatchesService;
import org.example.datn_website_be.service.BillByEmployeeService;
import org.example.datn_website_be.service.CartDetailService;
import org.example.datn_website_be.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DiscountScheduler {
    @Autowired
    private PromotionService promotionService;

    @Autowired
    private BillByEmployeeService billByEmployeeService;
    @Autowired
    private CartDetailService cartDetailService;
    @Autowired
    private BatchesService batchesService;
    @Scheduled(cron = "0 * * * * *")
    public void checkAndUpdateExpiredDiscounts() {
        promotionService.updateUpcomingDiscounts();
        promotionService.updateFinishedDiscounts();
        billByEmployeeService.findBillsOlder();
        cartDetailService.findCartDetailsOlderThanOneDay();
        batchesService.findByHSD();
    }
}
