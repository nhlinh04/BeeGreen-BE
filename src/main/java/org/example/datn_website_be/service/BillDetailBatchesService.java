package org.example.datn_website_be.service;

import org.example.datn_website_be.repository.BillDetailBatchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillDetailBatchesService {
    @Autowired
    BillDetailBatchesRepository billDetailBatchesRepository;
}
