package com.logius.digid.weatherproxy.repositories;

import com.logius.digid.weatherproxy.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.ws.rs.PathParam;
import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

    List<CityEntity> findByName(@Param("name") String name);
    void deleteByName(@PathParam("name") String name);

}
