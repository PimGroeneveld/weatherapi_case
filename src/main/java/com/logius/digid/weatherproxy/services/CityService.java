package com.logius.digid.weatherproxy.services;

import com.logius.digid.weatherproxy.entities.CityEntity;
import com.logius.digid.weatherproxy.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    @Autowired
    CityRepository repository;

    public List<CityEntity> getAllCities() {
        List<CityEntity> cityList = repository.findAll();

        if(cityList.size() > 0) {
            return cityList;
        } else {
            return new ArrayList<CityEntity>();
        }
    }

    public List<CityEntity> getCityByName(String name) {
        return repository.findByName(name);
    }

    public List<CityEntity> createOrUpdateCity(CityEntity entity) throws NullPointerException {
        List<CityEntity> city = repository.findByName(entity.getName());

        if(!city.isEmpty()) {
            CityEntity newEntity = city.get(0);
            newEntity.setName(entity.getName());
            newEntity.setMinTemp(entity.getMinTemp());
            newEntity.setMaxTemp(entity.getMaxTemp());
            newEntity.setSunrise(entity.getSunrise());

            newEntity = repository.save(newEntity);
            List<CityEntity> result = new ArrayList<>();
            result.add(newEntity);

            return result;
        } else {
            entity = repository.save(entity);
            List<CityEntity> result = new ArrayList<>();
            result.add(entity);

            return result;
        }
    }

    @Transactional
    public void deleteCityByName(String name) {
        repository.deleteByName(name);
    }
}

