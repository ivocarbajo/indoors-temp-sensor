package com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.service;

import com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.model.Reading;
import com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ReadingService {
    private final ReadingRepository readingRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public ReadingService(ReadingRepository readingRepository, RestTemplateBuilder restTemplateBuilder) {
        this.readingRepository = readingRepository;
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Reading> getReadings() {
        return readingRepository.findAllByOrderByDateDesc();
    }

    public void addReading(Reading reading) {
        reading.setDate(LocalDateTime.now());
        readingRepository.save(reading);
    }

    public void importReadingsFrom(String url) {
        List<Reading> readings = new ArrayList<>();
        ResponseEntity<Reading[]> response = restTemplate.getForEntity(url, Reading[].class);

        try {
            readings = List.of(Objects.requireNonNull(response.getBody()));
        } catch (NullPointerException e) {
            System.out.println("Data import function was run, but no readings could be imported because there were none or the request failed");
        }

        readingRepository.saveAll(readings);
    }

    public List<Reading> getLatestReadings() {
        return readingRepository.findTop100ByOrderByDateDesc();
    }

    public List<Reading> getLatestReadings(int limit) {
        return readingRepository.findAllByOrderByDateDesc(PageRequest.of(0, limit));
    }
}
