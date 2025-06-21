package com.innovationhub.report_service.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.innovationhub.report_service.dto.BillDTO;
import com.innovationhub.report_service.dto.ExpenseDTO;
import com.innovationhub.report_service.dto.ReportResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final RestTemplate restTemplate;

    @Value("${api.gateway.url}")
    private String apiGatewayUrl;

    @CircuitBreaker(name = "expenseService", fallbackMethod = "expenseFallback")
    public List<ExpenseDTO> fetchExpenses(String usrid) {
        return Arrays.asList(restTemplate.getForObject(
            apiGatewayUrl + "/api/expenses/user/" + usrid,
            ExpenseDTO[].class));
    }

    @CircuitBreaker(name = "billingService", fallbackMethod = "billFallback")
    public List<BillDTO> fetchBills(String usrid) {
        return Arrays.asList(restTemplate.getForObject(
            apiGatewayUrl + "/api/bills/user/" + usrid,
            BillDTO[].class));
    }

    public ReportResponse generateReport(String usrid, String email) {
        List<ExpenseDTO> expenses = fetchExpenses(usrid);
        List<BillDTO> bills = fetchBills(usrid);

        double totalExpenses = expenses.stream().mapToDouble(ExpenseDTO::getAmount).sum();
        double totalBills = bills.stream().mapToDouble(BillDTO::getAmount).sum();

        ReportResponse response = new ReportResponse();
        response.setUserEmail(email);
        response.setExpenses(expenses);
        response.setBills(bills);
        response.setTotalExpenses(totalExpenses);
        response.setTotalBills(totalBills);
        return response;
    }

    public List<ExpenseDTO> expenseFallback(String usrid, Throwable t) {
        System.out.println("Fallback triggered for expense-service: " + t.getMessage());
        return Collections.emptyList(); // Return empty list or cached data
    }

    public List<BillDTO> billFallback(String usrid, Throwable t) {
        System.out.println("Fallback triggered for billing-service: " + t.getMessage());
        return Collections.emptyList();
    }
}
