package org.example.datn_website_be.controller;

import jakarta.validation.Valid;
import org.example.datn_website_be.dto.request.AccountRequest;
import org.example.datn_website_be.dto.request.BatchesRequest;
import org.example.datn_website_be.dto.response.Response;
import org.example.datn_website_be.service.BatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/batches")
public class BatchesRestAPI {
    @Autowired
    BatchesService  batchesService;
    @PostMapping("/create")
    public ResponseEntity<?> createBatches(@RequestBody @Valid BatchesRequest batchesRequest, BindingResult result) {
        System.out.println("batchesRequest "+batchesRequest.getNsx());
        System.out.println("batchesRequest "+batchesRequest.getHsd());
        try {
            if (result.hasErrors()) {
                List<String> errors = result.getAllErrors().stream()
                        .map(error -> error.getDefaultMessage())
                        .collect(Collectors.toList());
                return ResponseEntity.badRequest().body(errors);
            }
            batchesService.createBatches(batchesRequest);
            return ResponseEntity.ok("Nhập hàng thành công!");
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Response.builder()
                            .status(HttpStatus.CONFLICT.toString())
                            .mess(e.getMessage())
                            .build()
                    );
        }
    }
}
