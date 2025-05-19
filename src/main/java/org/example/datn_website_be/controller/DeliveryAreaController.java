package org.example.datn_website_be.controller;

import lombok.RequiredArgsConstructor;
import org.example.datn_website_be.model.District;
import org.example.datn_website_be.model.Ward;
import org.example.datn_website_be.service.DeliveryAreaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/delivery-area")
@RequiredArgsConstructor
public class DeliveryAreaController {

    private final DeliveryAreaService deliveryAreaService;

    @GetMapping("/districts")
    public ResponseEntity<List<District>> getActiveDistricts() {
        List<District> districts = deliveryAreaService.getAllActiveDistricts();
        return ResponseEntity.ok(districts); // returns 200 OK status with the list of districts
    }

    @GetMapping("/districts/all")
    public ResponseEntity<List<District>> getAllDistricts() {
        List<District> districts = deliveryAreaService.getAllDistricts();
        return ResponseEntity.ok(districts); // returns 200 OK status with the list of districts
    }

    @GetMapping("/districts/{districtId}/wards")
    public ResponseEntity<List<Ward>> getActiveWardsByDistrict(@PathVariable Long districtId) {
        List<Ward> wards = deliveryAreaService.getActiveWardsByDistrict(districtId);
        return ResponseEntity.ok(wards);
    }

    @PostMapping("/districts/{districtId}/disable")
    public ResponseEntity<Void> disableDistrict(@PathVariable Long districtId) {
        deliveryAreaService.disableDistrict(districtId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/districts/{districtId}/enable")
    public ResponseEntity<Void> enableDistrict(@PathVariable Long districtId) {
        deliveryAreaService.enableDistrict(districtId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/wards/{wardId}/disable")
    public ResponseEntity<Void> disableWard(@PathVariable Long wardId) {
        deliveryAreaService.disableWard(wardId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/wards/{wardId}/enable")
    public ResponseEntity<Void> enableWard(@PathVariable Long wardId) {
        deliveryAreaService.enableWard(wardId);
        return ResponseEntity.noContent().build();
    }


}
