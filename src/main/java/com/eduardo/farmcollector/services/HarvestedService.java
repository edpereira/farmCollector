package com.eduardo.farmcollector.services;

import com.eduardo.farmcollector.entities.Harvested;
import com.eduardo.farmcollector.repositories.HarvestedRepository;
import org.springframework.stereotype.Service;

@Service
public class HarvestedService {

    private final HarvestedRepository harvestedRepository;

    public HarvestedService(HarvestedRepository harvestedRepository) {
        this.harvestedRepository = harvestedRepository;
    }

    public void execute(Harvested harvested) {
        harvestedRepository.saveHarvestedData(harvested);
    }
}
