package com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.service;

import com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.model.Reading;
import com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.repository.ReadingRepository;
import com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.utils.InvalidImportUrlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.UnknownHostException;
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

    public void importReadingsFrom(String url) throws InvalidImportUrlException, UnknownHostException {
        List<Reading> readings;
        ResponseEntity<Reading[]> response = restTemplate.getForEntity(url, Reading[].class);

        if (response.getBody() != null) {
            readings = List.of(response.getBody());
        } else {
            throw new InvalidImportUrlException();
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
