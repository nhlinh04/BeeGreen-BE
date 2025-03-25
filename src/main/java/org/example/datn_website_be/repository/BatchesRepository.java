package org.example.datn_website_be.repository;

import org.example.datn_website_be.dto.response.BatchesBillRespnse;
import org.example.datn_website_be.model.Account;
import org.example.datn_website_be.model.Batches;
import org.example.datn_website_be.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchesRepository extends JpaRepository<Batches, Long> {
    @Query("""
            select b from Batches b
            join b.product p
            where b.status =:status 
            and p.id =:id
            and b.quantity > 0
            order by b.HSD asc
            """)
    List<Batches> findByProductAndStatus(Long id, String status);

    @Query("""
            select new org.example.datn_website_be.dto.response.BatchesBillRespnse(
                b.id, b.quantity, b.NSX, b.HSD, bdb.quantity
            ) 
            from Batches b
            join b.product p
            join b.billDetailBatches bdb
            join bdb.billDetail bd
            where p.id=:idProduct and bd.id=:idBillDetail
            order by b.HSD desc 
                """)
    List<BatchesBillRespnse> findBatches(@Param("idProduct") Long idProduct, @Param("idBillDetail") Long idBillDetail);

    @Query("""
            select b
            from Batches b
            join b.product p
            where p.id=:idProduct
            order by b.createdAt desc 
                """)
    List<Batches> findByProductId(@Param("idProduct") Long idProduct);

    Batches findByCode(String codeBatches);
    @Query("SELECT b FROM Batches b WHERE b.HSD < CURRENT_DATE")
    List<Batches> findByHSD();
}
