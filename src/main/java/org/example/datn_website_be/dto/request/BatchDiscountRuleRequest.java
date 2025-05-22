package org.example.datn_website_be.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatchDiscountRuleRequest {
    @NotNull(message = "Số ngày trước khi hết hạn không được để trống")
    @Min(value = 0, message = "Số ngày trước khi hết hạn phải lớn hơn hoặc bằng 0")
    private Integer daysBeforeExpiry;

    @NotNull(message = "Phần trăm giảm giá không được để trống")
    @Min(value = 0, message = "Phần trăm giảm giá phải lớn hơn hoặc bằng 0")
    @Max(value = 100, message = "Phần trăm giảm giá phải nhỏ hơn hoặc bằng 100")
    private Integer discountPercent;

    @NotBlank(message = "Trạng thái không được để trống")
    @Pattern(regexp = "ACTIVE|INACTIVE", message = "Trạng thái chỉ được phép là 'ACTIVE' hoặc 'INACTIVE'")
    private String status;
}
