package org.example.datn_website_be.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.datn_website_be.dto.request.BatchDiscountRuleRequest;
import org.example.datn_website_be.model.BatchDiscountRule;
import org.example.datn_website_be.service.BatchDiscountRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/discount-near-expiration")
@RequiredArgsConstructor
public class BatchDiscountRuleController {
    private final BatchDiscountRuleService service;

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<BatchDiscountRule> create(@RequestBody @Valid BatchDiscountRuleRequest request) {
        return ResponseEntity.ok(service.add(request));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<BatchDiscountRule> update(@PathVariable Long id,
                                                    @RequestBody @Valid BatchDiscountRuleRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BatchDiscountRule>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BatchDiscountRule> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/update-status")
    public ResponseEntity<?> updateDiscountStatus(@RequestParam Long id, @RequestParam Boolean aBoolean) {
        service.updateStatus(id, aBoolean);
        return ResponseEntity.ok("Cập nhật trạng thái thành công");
    }
}
