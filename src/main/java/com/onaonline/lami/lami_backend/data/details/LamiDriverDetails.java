package com.onaonline.lami.lami_backend.data.details;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class LamiDriverDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    private String drivername;
    private String driveridnumber;
    private String phonenumber;
    private String email;
    private boolean availiable;
    private String license_plate;
    private String location;
    private String ride_status;


    public LamiDriverDetails( String drivername, String driveridnumber, String phonenumber, String email, boolean availiable, String license_plate, String location, String ride_status) {
        this.drivername = drivername;
        this.driveridnumber = driveridnumber;
        this.phonenumber = phonenumber;
        this.email = email;
        this.availiable = availiable;
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
                ", license_plate='" + license_plate + '\'' +
                ", location='" + location + '\'' +
                ", ride_status='" + ride_status + '\'' +
                '}';
    }
}
