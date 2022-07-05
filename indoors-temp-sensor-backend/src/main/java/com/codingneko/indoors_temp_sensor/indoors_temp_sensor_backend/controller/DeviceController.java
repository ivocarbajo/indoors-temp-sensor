package com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.controller;

import com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.model.Device;
import com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/device")
@CrossOrigin(origins = "http://localhost:4200")
public class DeviceController {
    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping(params = {"id"})
    public Device getDevice(@RequestParam long id) {
        return deviceService.getDevice(id);
    }

    @PostMapping
    public void addDevice(@RequestBody Device device) {
        deviceService.addDevice(device);
    }
}
