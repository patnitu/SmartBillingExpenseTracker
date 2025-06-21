package com.innovationhub.report_service.controller;


import com.innovationhub.report_service.dto.ReportResponse;
import com.innovationhub.report_service.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/report/{usrid}/{email}")
    public ReportResponse getReport(@PathVariable String email,@PathVariable String usrid) {
        return reportService.generateReport(usrid,email);
    }
}

