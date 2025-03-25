package org.example.datn_website_be.controller;

import jakarta.validation.Valid;
import org.example.datn_website_be.dto.request.AccountRequest;
import org.example.datn_website_be.dto.request.BatchesRequest;
import org.example.datn_website_be.dto.response.Response;
import org.example.datn_website_be.service.BatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findBatchesByIdProduct")
    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE')")
    public ResponseEntity<?> findBatchesByIdProduct(@RequestParam(value = "idProduct", required = false) Long idProduct) {
        try {
            if (idProduct == null) {
                return ResponseEntity.badRequest().body(
                        Response.builder()
                                .status(HttpStatus.BAD_REQUEST.toString())
                                .mess("Lỗi: ID của sản phẩm không được để trống!")
                                .build()
                );
            }
            return ResponseEntity.ok().body(batchesService.findBatchesByIdProduct(idProduct));
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
