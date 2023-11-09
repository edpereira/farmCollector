package com.eduardo.farmcollector.datasources.database.dto;

import jakarta.persistence.*;

@Entity
@Table
public class PlantedTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String farmName;
    @Column
    private String season;
    @Column
    private Integer plantingAreaAcres;
    @Column
    private String cropType;
    @Column
    private Integer expectedProductTons;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Integer getPlantingAreaAcres() {
        return plantingAreaAcres;
    }

    public void setPlantingAreaAcres(Integer plantingAreaAcres) {
        this.plantingAreaAcres = plantingAreaAcres;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public Integer getExpectedProductTons() {
        return expectedProductTons;
    }

    public void setExpectedProductTons(Integer expectedProductTons) {
        this.expectedProductTons = expectedProductTons;
    }
}
