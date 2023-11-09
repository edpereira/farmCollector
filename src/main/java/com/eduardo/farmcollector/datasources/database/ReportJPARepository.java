package com.eduardo.farmcollector.datasources.database;

import com.eduardo.farmcollector.datasources.database.dto.PlantedTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportJPARepository extends JpaRepository<PlantedTable, Long> {

    @Query("SELECT pt.farmName AS typeName, SUM(pt.expectedProductTons) AS expected, SUM(ht.actualProductTons) AS actual " +
            "FROM PlantedTable pt " +
            "INNER JOIN HarvestedTable ht ON pt.cropType = ht.cropType AND pt.farmName = ht.farmName AND pt.season = ht.season " +
            "WHERE pt.season = :season " +
            "GROUP BY pt.farmName")
    List<String> findByFarmName(@Param("season") String season);

    @Query("SELECT pt.cropType AS typeName, SUM(pt.expectedProductTons) AS expected, SUM(ht.actualProductTons) AS actual " +
            "FROM PlantedTable pt " +
            "INNER JOIN HarvestedTable ht ON pt.cropType = ht.cropType AND pt.farmName = ht.farmName AND pt.season = ht.season " +
            "WHERE pt.season = :season " +
            "GROUP BY pt.cropType")
    List<String> findByCropType(@Param("season") String season);

}
