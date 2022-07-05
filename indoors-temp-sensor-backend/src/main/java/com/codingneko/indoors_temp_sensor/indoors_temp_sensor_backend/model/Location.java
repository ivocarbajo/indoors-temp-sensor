package com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.model;

import com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.utils.Coordinates;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
@Entity
public class Location {
    @Id
    @SequenceGenerator(
            name = "location_sequence",
            sequenceName = "location_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long Id;
    private String name;
    private Coordinates coordinates;

    public Location(int id, String name, Coordinates coordinates) {
        Id = id;
        this.name = name;
        this.coordinates = coordinates;
    }

    public Location() {
    }

    public long getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
