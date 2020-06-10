package com.logius.digid.weatherproxy.controllers;

import com.logius.digid.weatherproxy.entities.CityEntity;
import com.logius.digid.weatherproxy.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/weatherproxy")
public class CityController {

    @Autowired
    CityService service;

    @GetMapping("/cities")
    public ResponseEntity<List<CityEntity>> getAllCities() {
        List<CityEntity> list = service.getAllCities();
        return new ResponseEntity<List<CityEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("cities/{name}")
    public ResponseEntity<CityEntity> getCityByName(@PathVariable("name") String name) throws NullPointerException {
        List<CityEntity> entity = service.getCityByName(name);
        if(entity.size() == 0){
            return new ResponseEntity("404. No match found for city with name: " + name, new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CityEntity>(entity.get(0), new HttpHeaders(), HttpStatus.OK);

    }

    @PostMapping("cities/{name}")
    public ResponseEntity<CityEntity> createOrUpdateCity(CityEntity city) throws NullPointerException {
        CityEntity updated = service.createOrUpdateCity(city).get(0);
        return new ResponseEntity<CityEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("cities/{name}")
    public HttpStatus deleteCityByName(@PathVariable("name") String name) throws NullPointerException {
        service.deleteCityByName(name);
        return HttpStatus.FORBIDDEN;
    }

}
