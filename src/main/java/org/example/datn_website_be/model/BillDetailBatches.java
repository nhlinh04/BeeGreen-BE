package org.example.datn_website_be.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "BillDetailBatches")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillDetailBatches extends BaseEntity {

    @Column
    private double quantity;

    @JsonBackReference(value = "billDetailBatchesBatchesReference")
    @ManyToOne
    @JoinColumn(name = "id_batches", referencedColumnName = "id")
    private Batches batches;

    @JsonBackReference(value = "billDetailBatchesBillDetailReference")
    @ManyToOne
    @JoinColumn(name = "id_billDetail", referencedColumnName = "id")
    private BillDetail billDetail;
}
