package com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.repository;

import com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.model.Device;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeviceRepository extends CrudRepository<Device, Long> {
    List<Device> findAll();
    Device getById(long id);
}
