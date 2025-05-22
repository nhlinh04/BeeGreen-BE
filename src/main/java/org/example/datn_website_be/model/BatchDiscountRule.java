package org.example.datn_website_be.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "batch_discount_rules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatchDiscountRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "days_before_expiry", nullable = false, unique = true)
    private int daysBeforeExpiry;

    @Column(name = "discount_percent", nullable = false, precision = 5, scale = 2)
    private int discountPercent;

    @Column(name = "status", nullable = false)
    private String status;

}

