package com.logius.digid.weatherproxy.controllers;

import com.logius.digid.weatherproxy.WeatherproxyApplication;
import com.logius.digid.weatherproxy.entities.CityEntity;
import com.logius.digid.weatherproxy.services.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/weatherproxy")
public class CityController {

    @Autowired
    CityService service;

    @Value("${api.key}")
    private String apiKey;

    private static final Logger log = LoggerFactory.getLogger(WeatherproxyApplication.class);

    @RequestMapping("/")
    public String home() {
        return "Running this via Docker";
    }

    @GetMapping("cities")
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
        RestTemplate restTemplate = new RestTemplate();
        CityEntity city = restTemplate.getForObject(
                "https://api.openweathermap.org/data/2.5/weather?q="+name+"&appid="+apiKey, CityEntity.class);
        log.info("city from cities/{name}: " + city.toString());
        return new ResponseEntity<CityEntity>(city, new HttpHeaders(), HttpStatus.OK);
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
