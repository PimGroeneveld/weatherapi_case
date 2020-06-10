package com.logius.digid.weatherproxy.services;

import com.logius.digid.weatherproxy.entities.CityEntity;
import com.logius.digid.weatherproxy.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    CityRepository repository;

    public List<CityEntity> getAllCities()
    {
        List<CityEntity> cityList = repository.findAll();

        if(cityList.size() > 0) {
            return cityList;
        } else {
            return new ArrayList<CityEntity>();
        }
    }

    public CityEntity getCityByName(String name) throws NullPointerException
    {
        Optional<CityEntity> city = repository.findByName(name);

        if(city.isPresent()) {
            return city.get();
        } else {
            throw new NullPointerException("No city exists for given name");
        }
    }

    public CityEntity createOrUpdateCity(CityEntity entity) throws NullPointerException
    {
        Optional<CityEntity> city = repository.findByName(entity.getName());

        if(city.isPresent())
        {
            CityEntity newEntity = city.get();
            newEntity.setName(entity.getName());
            newEntity.setMinTemp(entity.getMinTemp());
            newEntity.setMaxTemp(entity.getMaxTemp());
            newEntity.setSunrise(entity.getSunrise());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteCityByName(String name) throws NullPointerException
    {
        Optional<CityEntity> city = repository.findByName(name);

        if(city.isPresent())
        {
            repository.deleteByName(name);
        } else {
            throw new NullPointerException("No city exists for given name");
        }
    }
}

