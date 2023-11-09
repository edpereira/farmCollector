package com.eduardo.farmcollector.services;

import com.eduardo.farmcollector.entities.ReportByType;
import com.eduardo.farmcollector.repositories.ReportRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ReportServiceTest {

    @Test
    public void shouldCallGetReportByFarmNameWhenForEachTypeIs_farmer() {
        var repository = mock(ReportRepository.class);
        var service = new ReportService(repository);
        doReturn(Collections.EMPTY_LIST).when(repository).getReportByFarmName(anyString());

        service.execute("spring", "farmer");

        verify(repository, times(1)).getReportByFarmName(anyString());
        verify(repository, never()).getReportByCropType(anyString());
    }

    @Test
    public void shouldCallGetReportByFarmNameWhenForEachTypeIs_crop() {
        var repository = mock(ReportRepository.class);
        var service = new ReportService(repository);
        doReturn(Collections.EMPTY_LIST).when(repository).getReportByCropType(anyString());

        service.execute("spring", "crop");

        verify(repository, times(1)).getReportByCropType(anyString());
        verify(repository, never()).getReportByFarmName(anyString());
    }

    @Test
    public void shouldReturnReportByCrop() {
        List<ReportByType> reportList = Arrays.asList(
                new ReportByType("Corn", 100, 110),
                new ReportByType("Potato", 200, 220)
        );
        var repository = mock(ReportRepository.class);
        doReturn(reportList).when(repository).getReportByCropType(anyString());

        var service = new ReportService(repository);

        String result = service.execute("spring", "crop");

        String expected = "By crop:\nCorn: Expected: 100 / Actual: 110\nPotato: Expected: 200 / Actual: 220";
        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnReportByFarmerName() {
        List<ReportByType> reportList = Arrays.asList(
                new ReportByType("Eduardo", 100, 110),
                new ReportByType("Gabriela", 200, 220)
        );
        var repository = mock(ReportRepository.class);
        doReturn(reportList).when(repository).getReportByFarmName(anyString());

        var service = new ReportService(repository);

        String result = service.execute("spring", "farmer");

        String expected = "By farmer:\nEduardo: Expected: 100 / Actual: 110\nGabriela: Expected: 200 / Actual: 220";
        assertEquals(expected, result);
    }

}