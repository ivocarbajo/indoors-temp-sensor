package com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.model;

import com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.utils.Coordinates;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
@Entity
public class Owner {
    @Id
    @SequenceGenerator(
            name = "owner_sequence",
            sequenceName = "owner_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long Id;
    private String fullName;
    @ElementCollection
    private List<Device> devices;

    public Owner(int id, String fullName, List<Device> devices) {
        Id = id;
        this.fullName = fullName;
        this.devices = devices;
    }

    public Owner() {
    }

    public long getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
}
