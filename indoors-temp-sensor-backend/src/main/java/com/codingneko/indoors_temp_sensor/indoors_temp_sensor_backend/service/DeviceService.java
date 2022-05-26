package com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.service;

import com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {
    DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }


}
