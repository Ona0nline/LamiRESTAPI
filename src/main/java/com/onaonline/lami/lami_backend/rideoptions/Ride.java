package com.onaonline.lami.lami_backend.rideoptions;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public abstract class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Getter
    @Setter
    private String startLocation;
    @Getter
    @Setter
    private String endLocation;
    @Getter
    @Setter
    private Long driverid;
    @Getter
    @Setter
    private Long fare;

}
