package com.innovationhub.report_service.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ExpenseDTO {
	 private String category;
	 private double amount;
     private LocalDate date;
}
