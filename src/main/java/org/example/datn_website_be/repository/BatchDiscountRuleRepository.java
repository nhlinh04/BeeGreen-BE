package org.example.datn_website_be.repository;

import org.example.datn_website_be.model.BatchDiscountRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatchDiscountRuleRepository extends JpaRepository<BatchDiscountRule, Long> {

    List<BatchDiscountRule> findByStatus(String active);

    boolean existsByDaysBeforeExpiry(Integer daysBeforeExpiry);

}
