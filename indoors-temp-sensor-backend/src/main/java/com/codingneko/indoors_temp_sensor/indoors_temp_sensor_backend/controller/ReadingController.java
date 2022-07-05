package com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.controller;
import com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.service.ReadingService;
import com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.model.Reading;
import com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.utils.InvalidImportUrlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownContentTypeException;

import java.net.UnknownHostException;
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
    public ResponseEntity<String> importReadingsFrom(@RequestParam String url) {
        try {
            readingService.importReadingsFrom(url);
        } catch (InvalidImportUrlException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No records could be imported");
        } catch (UnknownContentTypeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The server at the provided URL was online" +
                    " and sent a reply, but its contents were not the expected response.");
        } catch (UnknownHostException e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("The server at the provided URL did not respond.");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Imported readings successfully");
    }

    @GetMapping(path = "getLatestReadings")
    public List<Reading> getLatestReadings() {
        return readingService.getLatestReadings();
    }

    @GetMapping(path = "getLatestReadings", params = {"limit"})
    public List<Reading> getLatestReadings(@RequestParam int limit) {
        return readingService.getLatestReadings(limit);
    }

    @PostMapping
    public void addReading(@RequestBody Reading reading) {
        readingService.addReading(reading);
    }
}
