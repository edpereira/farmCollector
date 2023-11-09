package com.eduardo.farmcollector.api.mappers;

import com.eduardo.farmcollector.entities.Planted;
import com.eduardo.farmcollector.model.PlantedData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlantedApiMapper {

    PlantedApiMapper INSTANCE = Mappers.getMapper(PlantedApiMapper.class);

    Planted toEntity(PlantedData request, String season);

}
