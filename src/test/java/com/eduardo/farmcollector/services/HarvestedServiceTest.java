package com.eduardo.farmcollector.services;

import com.eduardo.farmcollector.entities.Harvested;
import com.eduardo.farmcollector.repositories.HarvestedRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class HarvestedServiceTest {

    @Test
    public void shouldCallSaveHarvestedDataOnceWhenServiceExecute() {
        var repository = mock(HarvestedRepository.class);
        var service = new HarvestedService(repository);

        var request = new Harvested("Eduardo", "spring", "Potato", 10);
        service.execute(request);

        verify(repository, times(1)).saveHarvestedData(any(Harvested.class));
    }

}