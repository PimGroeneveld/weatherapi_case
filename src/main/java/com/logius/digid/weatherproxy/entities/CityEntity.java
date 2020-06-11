package com.logius.digid.weatherproxy.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "cities")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String name;

    @Column(name= "temp_min")
    private double minTemp;

    @Column(name= "temp_max")
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

    @Override
    public String toString() {
        return "Value{" +
                "id = " + Id +
                ", name = '" + name + '\'' +
                ", minimum temperature = '" + minTemp + '\'' +
                ", maximum temperature = '" + maxTemp + '\'' +
                ", sunrise = '" + sunrise + '\'' +
                '}';
    }
}
