package org.example.datn_website_be.service;

import lombok.AllArgsConstructor;
import org.example.datn_website_be.model.District;
import org.example.datn_website_be.model.Ward;
import org.example.datn_website_be.repository.DistrictRepository;
import org.example.datn_website_be.repository.WardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DeliveryAreaService {
    private final DistrictRepository districtRepository;
    private final WardRepository wardRepository;

    public List<District> getAllActiveDistricts() {
        return districtRepository.findByIsActiveTrue();
    }

    public List<Ward> getActiveWardsByDistrict(Long districtId) {
        return wardRepository.findByDistrictIdAndIsActiveTrue(districtId);
    }

    public void disableDistrict(Long districtId) {
        District district = districtRepository.findById(districtId)
                .orElseThrow(() -> new RuntimeException("District not found"));

        district.setIsActive(false);
        districtRepository.save(district);

        // Disable tất cả phường thuộc quận đó
        List<Ward> wards = wardRepository.findByDistrictId(districtId);
        for (Ward ward : wards) {
            ward.setIsActive(false);
        }
        wardRepository.saveAll(wards);
    }

    public void enableDistrict(Long districtId) {
        District district = districtRepository.findById(districtId)
                .orElseThrow(() -> new RuntimeException("District not found"));

        district.setIsActive(true);
        districtRepository.save(district);
    }

    public void disableWard(Long wardId) {
        Ward ward = wardRepository.findById(wardId)
                .orElseThrow(() -> new RuntimeException("Ward not found"));
        ward.setIsActive(false);
        wardRepository.save(ward);
    }

    public void enableWard(Long wardId) {
        Ward ward = wardRepository.findById(wardId)
                .orElseThrow(() -> new RuntimeException("Ward not found"));
        ward.setIsActive(true);
        wardRepository.save(ward);
    }

    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }
}
