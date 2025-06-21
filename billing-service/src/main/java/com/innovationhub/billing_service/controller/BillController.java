package com.innovationhub.billing_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovationhub.billing_service.entity.Bill;
import com.innovationhub.billing_service.service.BillService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/bills")
@RequiredArgsConstructor
public class BillController {
    private final BillService billService;

    @PostMapping
    public ResponseEntity<Bill> saveBill(@RequestBody Bill bill) {
        return ResponseEntity.ok(billService.saveBill(bill));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Bill>> getBillsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(billService.getBillsByUser(userId));
    }
}

