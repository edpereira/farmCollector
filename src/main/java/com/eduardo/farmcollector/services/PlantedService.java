package com.eduardo.farmcollector.services;

import com.eduardo.farmcollector.entities.Planted;
import com.eduardo.farmcollector.repositories.PlantedRepository;
import org.springframework.stereotype.Service;

@Service
public class PlantedService {

    private final PlantedRepository plantedRepository;

    public PlantedService(PlantedRepository plantedRepository) {
        this.plantedRepository = plantedRepository;
    }

    public void execute(Planted planted) {
        plantedRepository.savePlantedData(planted);
    }

}
