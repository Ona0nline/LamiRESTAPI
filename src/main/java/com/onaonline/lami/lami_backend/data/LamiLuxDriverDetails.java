package com.onaonline.lami.lami_backend.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

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
    private boolean is_availiable;
    private String car;
    private String license_plate;
    private String location;
    private String ride_status;
    private List<String> perks;
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
