package com.eduardo.farmcollector.services;

import com.eduardo.farmcollector.entities.ReportByType;
import com.eduardo.farmcollector.repositories.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public String execute(String season, String forEachType) {
        if ("farmer".equals(forEachType)) {
            var results = reportRepository.getReportByFarmName(season);
            return buildReport(forEachType, results);
        }
        if ("crop".equals(forEachType)) {
            var results = reportRepository.getReportByCropType(season);
            return buildReport(forEachType, results);
        }

        throw new IllegalArgumentException(String.format("Report type: %s is not supported", forEachType));
    }

    private String buildReport(String name, List<ReportByType> reportList) {
        var reportText = String.format("By %s:\n", name);

        List<String> formattedReports = reportList
                .stream()
                .map(report ->
                    String.format("%s: Expected: %d / Actual: %d", report.typeName(), report.expected(), report.actual()))
                .toList();

        String result = String.join("\n", formattedReports);

        return reportText.concat(result);
    }
}
