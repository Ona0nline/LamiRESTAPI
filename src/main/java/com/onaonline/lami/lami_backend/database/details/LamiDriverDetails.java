package com.onaonline.lami.lami_backend.database.details;

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
    private double latitude;
    private double longitude;
    private String placeName;
    private String ride_status;
    private String perks;

//    Location data changing from location -> place name, lat and long

    public LamiDriverDetails( String drivername, String driveridnumber, String phonenumber, String email, boolean availiable, String license_plate, double latitude, double longitude, String placeName, String ride_status, String perks) {
        this.drivername = drivername;
        this.driveridnumber = driveridnumber;
        this.phonenumber = phonenumber;
        this.email = email;
        this.availiable = availiable;
        this.license_plate = license_plate;
        this.latitude = latitude;
        this.longitude = longitude;
        this.placeName = placeName;
        this.ride_status = ride_status;
        this.perks = perks;
    }

    public LamiDriverDetails() {

    }


    @Override
    public String toString() {
        return "LamiDriverDetails{" +
                "id=" + id +
                ", drivername='" + drivername + '\'' +
                ", driveridnumber='" + driveridnumber + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", email='" + email + '\'' +
                ", availiable=" + availiable +
                ", license_plate='" + license_plate + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", placeName='" + placeName + '\'' +
                ", ride_status='" + ride_status + '\'' +
                '}';
    }
}
