package com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface ReadingRepository extends Repository<Reading, Long> {
    List<Reading> findAll();
    void save(Reading reading);
    List<Reading> findTop100By();
}
