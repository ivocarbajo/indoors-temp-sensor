package com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
@Entity
public class Device {
    @Id
    @SequenceGenerator(
            name = "device_sequence",
            sequenceName = "device_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int Id;
    @OneToMany
    private List<Reading> readings;
    @ManyToOne
    private Location location;

    public Device(int id, List<Reading> readings, Location location) {
        Id = id;
        this.readings = readings;
        this.location = location;
    }

    public Device() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public List<Reading> getReadings() {
        return readings;
    }

    public void setReadings(List<Reading> readings) {
        this.readings = readings;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
