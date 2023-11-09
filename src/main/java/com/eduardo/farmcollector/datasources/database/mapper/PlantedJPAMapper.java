package com.eduardo.farmcollector.datasources.database.mapper;

import com.eduardo.farmcollector.datasources.database.dto.PlantedTable;
import com.eduardo.farmcollector.entities.Planted;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlantedJPAMapper {

    PlantedJPAMapper INSTANCE = Mappers.getMapper(PlantedJPAMapper.class);

    PlantedTable toDTO(Planted entity, Long id);

}
