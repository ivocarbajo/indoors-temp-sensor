package com.codingneko.indoors_temp_sensor.indoors_temp_sensor_backend.utils;

import org.hibernate.usertype.UserType;

import javax.persistence.Embeddable;

@Embeddable
public class Coordinates {
    double Latitude;
    double Longitude;

    public Coordinates(double latitude, double longitude) {
        Latitude = latitude;
        Longitude = longitude;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }
}
