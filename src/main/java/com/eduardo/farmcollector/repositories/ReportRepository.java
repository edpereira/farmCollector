package com.eduardo.farmcollector.repositories;

import com.eduardo.farmcollector.entities.ReportByType;

import java.util.List;

public interface ReportRepository {

    List<ReportByType> getReportByFarmName(String season);
    List<ReportByType> getReportByCropType(String season);

}
