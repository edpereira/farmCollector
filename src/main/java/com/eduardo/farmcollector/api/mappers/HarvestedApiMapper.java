package com.eduardo.farmcollector.api.mappers;

import com.eduardo.farmcollector.entities.Harvested;
import com.eduardo.farmcollector.entities.Planted;
import com.eduardo.farmcollector.model.HarvestedData;
import com.eduardo.farmcollector.model.PlantedData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HarvestedApiMapper {

    HarvestedApiMapper INSTANCE = Mappers.getMapper(HarvestedApiMapper.class);

    Harvested toEntity(HarvestedData request, String season);

}
