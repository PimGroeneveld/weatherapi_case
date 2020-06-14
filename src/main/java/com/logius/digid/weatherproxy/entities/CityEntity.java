package com.logius.digid.weatherproxy.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "cities")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long Id;

    @Column
    private String name;

    @Column(name= "temp_min")
    private Double minTemp;

    @Column(name= "temp_max")
    private Double maxTemp;

    @Column
    private int sunrise;

    public CityEntity() {
    }

    public CityEntity(String name, Double minTemp, Double maxTemp, int sunrise) {
        this.name = name;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.sunrise = sunrise;
    }

    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("main")
    private void unpackNestedTemp(Map<String,Object> main) {
        this.minTemp = (Double)main.get("temp_min");
        this.maxTemp = (Double)main.get("temp_max");
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("sys")
    private void unpackNestedSunrise(Map<String,Object> sys) {
        this.sunrise = (int)sys.get("sunrise");
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
