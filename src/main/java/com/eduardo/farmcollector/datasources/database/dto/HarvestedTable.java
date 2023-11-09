package com.eduardo.farmcollector.datasources.database.dto;

import jakarta.persistence.*;

@Entity
@Table
public class HarvestedTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String farmName;
    @Column
    private String season;
    @Column
    private String cropType;
    @Column
    private Integer actualProductTons;

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

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public Integer getActualProductTons() {
        return actualProductTons;
    }

    public void setActualProductTons(Integer actualProductTons) {
        this.actualProductTons = actualProductTons;
    }
}
