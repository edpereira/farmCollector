package com.eduardo.farmcollector.datasources.database.mapper;

import com.eduardo.farmcollector.entities.ReportByType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReportJPAMapper {

    ReportJPAMapper INSTANCE = Mappers.getMapper(ReportJPAMapper.class);

    List<ReportByType> toReportByTypeList(List<String> rows);

    default ReportByType toReportByType(String row) {
        String[] parts = row.split(",");
        if (parts.length != 3) {
            throw new RuntimeException("Invalid row value: " + row);
        }

        String typeName = parts[0];
        Integer expected = Integer.parseInt(parts[1]);
        Integer actual = Integer.parseInt((parts[2]));

        return new ReportByType(typeName, expected, actual);
    }

}
