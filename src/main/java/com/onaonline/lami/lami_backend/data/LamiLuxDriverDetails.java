package com.onaonline.lami.lami_backend.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class LamiLuxDriverDetails {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    private String drivername;
    @Getter
    private String driveridnumber;
    @Getter
    private String phonenumber;
    @Getter
    private String email;
    @Getter
    private boolean is_availiable;
    @Getter
    private String car;
    @Getter
    private String license_plate;
    @Getter
    private String location;
    @Getter
    private String ride_status;
    @Getter
    private List<String> perks;
    @Getter
    private String driverlevel;


    @Override
    public String toString() {
        return "LamiLuxDriverDetails{" +
                "id=" + id +
                ", drivername='" + drivername + '\'' +
                ", driveridnumber='" + driveridnumber + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", email='" + email + '\'' +
                ", is_availiable=" + is_availiable +
                ", car='" + car + '\'' +
                ", license_plate='" + license_plate + '\'' +
                ", location='" + location + '\'' +
                ", ride_status='" + ride_status + '\'' +
                ", perks=" + perks +
                ", driverlevel='" + driverlevel + '\'' +
                '}';
    }
}
