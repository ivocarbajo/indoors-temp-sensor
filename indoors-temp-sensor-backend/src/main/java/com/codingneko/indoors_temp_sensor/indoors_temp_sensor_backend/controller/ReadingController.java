package com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.controller;
import com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.service.ReadingService;
import com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.model.Reading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(path = "/api/reading")
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping(path = "importReadingsFrom")
    public void importReadingsFrom(@RequestParam String url) {
        readingService.importReadingsFrom(url);
    }


    @GetMapping(path = "getLatestReadings")
    public List<Reading> getLatestReadings() {
        return readingService.getLatestReadings();
    }

    @PostMapping
    public void addReading(@RequestBody Reading reading) {
        readingService.addReading(reading);
    }
}
