package com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.repository;

import com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.model.Reading;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReadingRepository extends CrudRepository<Reading, Long> {
    List<Reading> findAllByOrderByDateDesc(Pageable pageable);
    List<Reading> findAllByOrderByDateDesc();
    List<Reading> findTop100ByOrderByDateDesc();
}
