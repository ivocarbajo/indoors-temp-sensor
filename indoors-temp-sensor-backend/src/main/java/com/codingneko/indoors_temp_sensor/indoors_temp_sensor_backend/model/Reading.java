package com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

@Component
@Entity
public class Reading {
    @Id
    @SequenceGenerator(
            name = "reading_sequence",
            sequenceName = "reading_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int Id;
    private int temperature;
    private float humidity;
    private LocalDateTime date;


    public Reading(int id, int temperature, float humidity, LocalDateTime date) {
        Id = id;
        this.temperature = temperature;
        this.humidity = humidity;
        this.date = date;
    }

    public Reading() {
    }

    @Override
    public String toString() {
        return "Reading{" +
                "Id=" + Id +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", date=" + date +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
