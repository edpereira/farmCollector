package com.eduardo.farmcollector.api;

import com.eduardo.farmcollector.services.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ReportApiImpl implements ReportsApiDelegate {

    private final ReportService reportService;

    public ReportApiImpl(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public ResponseEntity<String> getReport(String season, String forEachType) {
        var response = reportService.execute(season, forEachType);
        return ResponseEntity.ok(response);
    }
}
