package com.logius.digid.weatherproxy.entities;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String name;

    @Column(name= "min_temp")
    private double minTemp;

    @Column
    private double maxTemp;

    @Column
    private long sunrise;

    public CityEntity() {
    }

    public CityEntity(String name, double minTemp, double maxTemp, long sunrise) {
        this.name = name;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.sunrise = sunrise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }
}
