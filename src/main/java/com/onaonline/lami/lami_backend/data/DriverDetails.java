package com.onaonline.lami.lami_backend.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DriverDetails {
    @Id
    private long id;
    private String drivername;
    private String driveridnumber;
    private String phonenumber;
    private String email;
    private boolean is_availiable;
    private String car;
    private String license_plate;
    private String location;
    private String ride_status;

    public DriverDetails(Long id, String drivername, String driveridnumber, String phonenumber, String email, boolean is_availiable, String car, String license_plate, String location, String ride_status) {
        this.id = id;
        this.drivername = drivername;
        this.driveridnumber = driveridnumber;
        this.phonenumber = phonenumber;
        this.email = email;
        this.is_availiable = is_availiable;
        this.car = car;
        this.license_plate = license_plate;
        this.location = location;
        this.ride_status = ride_status;
    }

    public DriverDetails() {

    }

    public long getId() {
        return id;
    }

    public String getDrivername() {
        return drivername;
    }

    public String getDriveridnumber() {
        return driveridnumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public boolean isIs_availiable() {
        return is_availiable;
    }

    public String getCar() {
        return car;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public String getLocation() {
        return location;
    }

    public String getRide_status() {
        return ride_status;
    }

    @Override
    public String toString() {
        return "DriverDetails{" +
                "id='" + id + '\'' +
                ", drivername='" + drivername + '\'' +
                ", driveridnumber='" + driveridnumber + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", email='" + email + '\'' +
                ", is_availiable=" + is_availiable +
                ", car='" + car + '\'' +
                ", license_plate='" + license_plate + '\'' +
                ", location='" + location + '\'' +
                ", ride_status='" + ride_status + '\'' +
                '}';
    }
}
