package org.example.datn_website_be.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatchesRequest {

    private Long idProduct;

    @NotNull(message = "Số lượng của sản phẩm là bắt buộc")
    @Positive(message = "Số lượng phải lớn hơn 0")
    private double quantity;

    @NotNull(message = "Ngày sản xuất là bắt buộc")
    private Date nsx;

    @NotNull(message = "Hạn sử dụng là bắt buộc")
    private Date hsd;

    @AssertTrue(message = "Ngày sản xuất phải trước ngày hiện tại")
    public boolean isNSXValid() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nsxDate = nsx.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return nsx != null && nsxDate.isBefore(now);
    }

    @AssertTrue(message = "Hạn sử dụng phải sau ngày hiện tại và sau ngày sản xuất")
    public boolean isHSDValid() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime hsdDate = hsd.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime nsxDate = nsx.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        return hsd != null && hsdDate.isAfter(now) && (nsx == null || hsdDate.isAfter(nsxDate));
    }
}
