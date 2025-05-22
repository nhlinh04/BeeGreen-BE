package org.example.datn_website_be.dto.response;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BatchDiscountRuleResponse {
    private Long id;

    private Integer daysBeforeExpiry;

    private Integer discountPercent;

    private String status;
}
