package com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/reading")
public class ReadingController {
    private final ReadingService readingService;

    @Autowired
    public ReadingController(ReadingService readingService) {
        this.readingService = readingService;
    }

    @GetMapping
    public List<Reading> getReadings() {
        return readingService.getReadings();
    }

    @GetMapping(path = "latest")
    public List<Reading> getLatestReadings() {
        return readingService.getLatestReadings();
    }

    @PostMapping
    public void addReading(@RequestBody Reading reading) {
        readingService.addReading(reading);
    }
}
