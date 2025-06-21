package com.innovationhub.billing_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innovationhub.billing_service.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
	 List<Bill> findByUserId(Long userId);
}
