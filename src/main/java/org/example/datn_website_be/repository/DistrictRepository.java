package org.example.datn_website_be.repository;

import org.example.datn_website_be.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
    List<District> findByIsActiveTrue();
}
