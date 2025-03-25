package org.example.datn_website_be.repository;

import org.example.datn_website_be.model.Account;
import org.example.datn_website_be.model.Batches;
import org.example.datn_website_be.model.BillDetail;
import org.example.datn_website_be.model.BillDetailBatches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillDetailBatchesRepository extends JpaRepository<BillDetailBatches, Long> {

    Optional<BillDetailBatches> findByBatchesAndBillDetail(Batches batches, BillDetail billDetail);
    void deleteByBillDetail(BillDetail billDetail);
}
