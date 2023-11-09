package com.eduardo.farmcollector.datasources;

import com.eduardo.farmcollector.datasources.database.HarvestedJPARepository;
import com.eduardo.farmcollector.datasources.database.mapper.HarvestedJPAMapper;
import com.eduardo.farmcollector.entities.Harvested;
import com.eduardo.farmcollector.repositories.HarvestedRepository;
import org.springframework.stereotype.Component;

@Component
public class HarvestedDatasource implements HarvestedRepository {

    private final HarvestedJPARepository harvestedJPARepository;

    public HarvestedDatasource(HarvestedJPARepository harvestedJPARepository) {
        this.harvestedJPARepository = harvestedJPARepository;
    }

    @Override
    public void saveHarvestedData(Harvested harvested) {
        var harvestedInfo = harvestedJPARepository
                .findByFarmNameAndCropTypeAndSeason(harvested.farmName(), harvested.cropType(), harvested.season());
        Long id = null;
        if (harvestedInfo.isPresent()) {
            id = harvestedInfo.get().getId();
        }

        harvestedJPARepository.save(HarvestedJPAMapper.INSTANCE.toDTO(harvested, id));
    }
}
