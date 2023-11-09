package com.eduardo.farmcollector.datasources.database;

import com.eduardo.farmcollector.datasources.database.dto.PlantedTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlantedJPARepository extends JpaRepository<PlantedTable, Long> {

    Optional<PlantedTable> findByFarmNameAndCropTypeAndSeason(String farmName, String cropType, String season);

}
