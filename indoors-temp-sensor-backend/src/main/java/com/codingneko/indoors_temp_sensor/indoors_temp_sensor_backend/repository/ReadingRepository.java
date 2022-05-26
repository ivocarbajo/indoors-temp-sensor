package com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.repository;

import com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.model.Reading;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ReadingRepository extends CrudRepository<Reading, Long> {
    List<Reading> findAll();
    List<Reading> findTop100By();
}
