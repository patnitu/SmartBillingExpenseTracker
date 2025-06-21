package com.innovationhub.expense_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innovationhub.expense_service.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	List<Expense> findByUserId(Long userId);
}
