package com.eduardo.farmcollector.api;

import com.eduardo.farmcollector.api.mappers.HarvestedApiMapper;
import com.eduardo.farmcollector.model.HarvestedData;
import com.eduardo.farmcollector.services.HarvestedService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class HarvestedApiImpl implements HarvestedApiDelegate {

    private final HarvestedService harvestedService;

    public HarvestedApiImpl(HarvestedService harvestedService) {
        this.harvestedService = harvestedService;
    }

    @Override
    public ResponseEntity<Void> postHarvestedData(String season, HarvestedData harvestedData) {
        var harvested = HarvestedApiMapper.INSTANCE.toEntity(harvestedData, season);
        harvestedService.execute(harvested);
        return ResponseEntity.status(201).build();
    }
}
