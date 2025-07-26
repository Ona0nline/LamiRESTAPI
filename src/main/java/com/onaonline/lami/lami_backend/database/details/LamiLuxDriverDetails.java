package com.onaonline.lami.lami_backend.database.details;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
public class LamiLuxDriverDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String drivername;
    private String driveridnumber;
    private String phonenumber;
    private String email;
    private boolean availiable;
    private String car;
    private String license_plate;
    private String ride_status;
    @ElementCollection(fetch = FetchType.EAGER)
//    This will load the perks list whenever a LamiLuxDriverDetails is fetched.
    private List<String> perks = new ArrayList<>();
    private String driverlevel;
    private double latitude;
    private double longitude;
    private String placename;
    private double fare;

//    public <T> LamiLuxDriverDetails(String thembaZwane, String number, String s, String mail, boolean b, String audiR8, String s1, String advancedDefensiveDriving, List<T> list, String s2, double v, double v1, String s3) {
//        this.drivername = thembaZwane;
//
//    }


    public LamiLuxDriverDetails(String drivername, String driveridnumber, String phonenumber, String email, boolean availiable, String car, String license_plate, String ride_status, List<String> perks, String driverlevel, double latitude, double longitude, String placename, double fare) {
        this.drivername = drivername;
        this.driveridnumber = driveridnumber;
        this.phonenumber = phonenumber;
        this.email = email;
        this.availiable = availiable;
        this.car = car;
        this.license_plate = license_plate;
        this.ride_status = ride_status;
        this.perks = perks;
        this.driverlevel = driverlevel;
        this.latitude = latitude;
        this.longitude = longitude;
        this.placename = placename;
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "LamiLuxDriverDetails{" +
                "id=" + id +
                ", drivername='" + drivername + '\'' +
                ", driveridnumber='" + driveridnumber + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", email='" + email + '\'' +
                ", availiable=" + availiable +
                ", car='" + car + '\'' +
                ", license_plate='" + license_plate + '\'' +
                ", ride_status='" + ride_status + '\'' +
                ", perks=" + perks +
                ", driverlevel='" + driverlevel + '\'' +
                '}';
    }
}
