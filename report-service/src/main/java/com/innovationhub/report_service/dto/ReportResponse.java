package com.innovationhub.report_service.dto;

import java.util.List;

import lombok.Data;

@Data
public class ReportResponse {
	private String userEmail;
    private List<ExpenseDTO> expenses;
    private List<BillDTO> bills;
    private double totalExpenses;
    private double totalBills;
}
