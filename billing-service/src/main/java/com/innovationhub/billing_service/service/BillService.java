package com.innovationhub.billing_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.innovationhub.billing_service.entity.Bill;
import com.innovationhub.billing_service.repository.BillRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BillService {
    private final BillRepository billRepository;

    public Bill saveBill(Bill bill) {
        return billRepository.save(bill);
    }

    public List<Bill> getBillsByUser(Long userId) {
        return billRepository.findByUserId(userId);
    }
}

