package org.example.datn_website_be.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Batches")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Batches extends BaseEntity{
    @Column
    private double quantity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date NSX;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date HSD;

    @Column
    private String code;

    @JsonBackReference(value = "productBatchesReference")
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private Product product;

    @JsonIgnore
    @JsonManagedReference(value = "billDetailBatchesBatchesReference")
    @OneToMany(mappedBy = "batches")
    private List<BillDetailBatches> billDetailBatches;

    @Column(name = "near_expiry_price")
    private double nearExpiryPrice;
}
