package com.eduardo.farmcollector.api;

import com.eduardo.farmcollector.api.mappers.PlantedApiMapper;
import com.eduardo.farmcollector.model.PlantedData;
import com.eduardo.farmcollector.services.PlantedService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PlantedApiImpl implements PlantedApiDelegate {

    private final PlantedService plantedService;

    public PlantedApiImpl(PlantedService plantedService) {
        this.plantedService = plantedService;
    }

    @Override
    public ResponseEntity<Void> postPlantedData(String season, PlantedData plantedData) {
        var planted = PlantedApiMapper.INSTANCE.toEntity(plantedData, season);
        plantedService.execute(planted);
        return ResponseEntity.status(201).build();
    }
}
