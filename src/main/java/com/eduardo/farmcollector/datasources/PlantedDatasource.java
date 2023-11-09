package com.eduardo.farmcollector.datasources;

import com.eduardo.farmcollector.datasources.database.PlantedJPARepository;
import com.eduardo.farmcollector.datasources.database.mapper.PlantedJPAMapper;
import com.eduardo.farmcollector.entities.Planted;
import com.eduardo.farmcollector.repositories.PlantedRepository;
import org.springframework.stereotype.Component;

@Component
public class PlantedDatasource implements PlantedRepository {

    private final PlantedJPARepository plantedJPARepository;

    public PlantedDatasource(PlantedJPARepository plantedJPARepository) {
        this.plantedJPARepository = plantedJPARepository;
    }

    @Override
    public void savePlantedData(Planted planted) {
        var plantedInfo = plantedJPARepository
                .findByFarmNameAndCropTypeAndSeason(planted.farmName(), planted.cropType(), planted.season());
        Long id = null;
        if (plantedInfo.isPresent()) {
            id = plantedInfo.get().getId();
        }
        plantedJPARepository.save(PlantedJPAMapper.INSTANCE.toDTO(planted, id));
    }
}
