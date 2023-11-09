package com.eduardo.farmcollector.services;

import com.eduardo.farmcollector.entities.Planted;
import com.eduardo.farmcollector.repositories.PlantedRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PlantedServiceTest {

    @Test
    public void shouldCallSavePlantedDataOnceWhenServiceExecute() {
        var repository = mock(PlantedRepository.class);
        var service = new PlantedService(repository);

        var request = new Planted("Eduardo", "spring", 10, "Potato", 100);
        service.execute(request);

        verify(repository, times(1)).savePlantedData(any(Planted.class));
    }

}