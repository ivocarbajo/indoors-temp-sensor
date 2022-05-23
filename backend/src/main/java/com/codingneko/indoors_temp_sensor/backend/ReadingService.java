package com.codingneko.indoors_temp_sensor.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReadingService {
    private final ReadingRepository readingRepository;

    @Autowired
    public ReadingService(ReadingRepository readingRepository) {
        this.readingRepository = readingRepository;
    }

    public List<Reading> getReadings() {
        return readingRepository.findAll();
    }

    public void addReading(Reading reading) {
        reading.setDate(LocalDateTime.now());
        readingRepository.save(reading);
    }

    public List<Reading> getLatestReadings() {
        return readingRepository.findTop100By();
    }
}
