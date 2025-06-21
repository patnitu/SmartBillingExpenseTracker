package com.innovationhub.report_service.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BillDTO {
	private String billName;
    private double amount;
    private LocalDate date;
}
