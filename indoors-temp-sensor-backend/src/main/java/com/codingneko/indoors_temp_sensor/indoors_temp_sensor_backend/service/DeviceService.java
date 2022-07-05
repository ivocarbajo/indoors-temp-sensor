package com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.service;

import com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.model.Device;
import com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Device getDevice(long id) {
        return this.deviceRepository.getById(id);
    }

    public void addDevice(Device device) {
        this.deviceRepository.save(device);
    }

}
