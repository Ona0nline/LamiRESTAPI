package com.onaonline.lami.lami_backend.rideoptions;

import com.onaonline.lami.lami_backend.externalApis.distancematrix.DistanceMatrixResponseDTO;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
public abstract class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placename;
    private double latitude;
    private double longitude;
    public Long driverid;
    private Long fare;


}
