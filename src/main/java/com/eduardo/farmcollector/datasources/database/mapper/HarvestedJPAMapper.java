package com.eduardo.farmcollector.datasources.database.mapper;

import com.eduardo.farmcollector.datasources.database.dto.HarvestedTable;
import com.eduardo.farmcollector.entities.Harvested;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HarvestedJPAMapper {

    HarvestedJPAMapper INSTANCE = Mappers.getMapper(HarvestedJPAMapper.class);

    HarvestedTable toDTO(Harvested entity, Long id);

}
