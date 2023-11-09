package com.eduardo.farmcollector.datasources;

import com.eduardo.farmcollector.datasources.database.ReportJPARepository;
import com.eduardo.farmcollector.datasources.database.mapper.ReportJPAMapper;
import com.eduardo.farmcollector.entities.ReportByType;
import com.eduardo.farmcollector.repositories.ReportRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReportDatasource implements ReportRepository {

    private final ReportJPARepository reportJPARepository;

    public ReportDatasource(ReportJPARepository reportJPARepository) {
        this.reportJPARepository = reportJPARepository;
    }

    @Override
    public List<ReportByType> getReportByFarmName(String season) {
        var result = reportJPARepository.findByFarmName(season);
        return ReportJPAMapper.INSTANCE.toReportByTypeList(result);
    }

    @Override
    public List<ReportByType> getReportByCropType(String season) {
        var result = reportJPARepository.findByCropType(season);
        return ReportJPAMapper.INSTANCE.toReportByTypeList(result);
    }
}
