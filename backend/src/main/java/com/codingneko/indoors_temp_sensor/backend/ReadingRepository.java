package com.codingneko.indoors_temp_sensor.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ReadingRepository extends Repository<Reading, Long> {
    List<Reading> findAll();
    void save(Reading reading);
    List<Reading> findTop100By();
}
