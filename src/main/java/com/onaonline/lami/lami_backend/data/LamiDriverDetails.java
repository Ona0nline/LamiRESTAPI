package com.onaonline.lami.lami_backend.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
public class LamiDriverDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    public long id;
    @Getter
    private String drivername;
    @Getter
    private String driveridnumber;
    @Getter
    private String phonenumber;
    @Getter
    private String email;
    @Getter
    private boolean availiable;
    @Getter
    private String car;
    @Getter
    private String license_plate;
    @Getter
    private String location;
    @Getter
    private String ride_status;


    public LamiDriverDetails( String drivername, String driveridnumber, String phonenumber, String email, boolean availiable, String car, String license_plate, String location, String ride_status) {
        this.drivername = drivername;
        this.driveridnumber = driveridnumber;
        this.phonenumber = phonenumber;
        this.email = email;
        this.availiable = availiable;
        this.car = car;
        this.license_plate = license_plate;
        this.location = location;
        this.ride_status = ride_status;
    }

    public LamiDriverDetails() {

    }


    @Override
    public String toString() {
        return "DriverDetails{" +
                "id='" + id + '\'' +
                ", drivername='" + drivername + '\'' +
                ", driveridnumber='" + driveridnumber + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", email='" + email + '\'' +
                ", is_availiable=" + availiable +
                ", car='" + car + '\'' +
                ", license_plate='" + license_plate + '\'' +
                ", location='" + location + '\'' +
                ", ride_status='" + ride_status + '\'' +
                '}';
    }
}
