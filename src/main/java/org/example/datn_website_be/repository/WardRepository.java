package org.example.datn_website_be.repository;

import org.example.datn_website_be.model.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WardRepository extends JpaRepository<Ward, Long> {
    List<Ward> findByDistrictId(Long districtId);
    List<Ward> findByDistrictIdAndIsActiveTrue(Long districtId);

}