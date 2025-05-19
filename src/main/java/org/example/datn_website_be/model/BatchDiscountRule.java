package org.example.datn_website_be.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "batch_discount_rules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatchDiscountRule extends BaseEntity {

    @Column(name = "days_before_expiry", nullable = false)
    private int daysBeforeExpiry;

    @Column(name = "discount_percent", nullable = false, precision = 5, scale = 2)
    private int discountPercent;

}

