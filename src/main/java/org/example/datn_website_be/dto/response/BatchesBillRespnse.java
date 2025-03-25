package org.example.datn_website_be.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BatchesBillRespnse {

    private Long idBatches;

    private double quantityBatches;

    private Date NSX;

    private Date HSD;

    private double quantityBillDetailBatches;
}
