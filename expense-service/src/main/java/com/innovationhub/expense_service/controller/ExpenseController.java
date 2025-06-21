package com.innovationhub.expense_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovationhub.expense_service.model.Expense;
import com.innovationhub.expense_service.service.ExpenseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
public class ExpenseController {
	   
	   private final ExpenseService expenseService;

	    @PostMapping
	    public Expense addExpense(@RequestBody Expense expense) {
	        return expenseService.addExpense(expense);
	    }

	    @GetMapping("/user/{userId}")
	    public List<Expense> getUserExpenses(@PathVariable Long userId) {
	        return expenseService.getUserExpenses(userId);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteExpense(@PathVariable Long id) {
	        expenseService.deleteExpense(id);
	    }
}
