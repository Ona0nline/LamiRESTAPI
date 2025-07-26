package com.onaonline.lami.lami_backend.externalApis.distancematrix;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DistanceMatrixLuxResponseDTO {
    
    private double duration;
    private double distance;
    private double fare;


    public DistanceMatrixLuxResponseDTO(double durationSeconds, double distanceMeters, double fare) {
        this.duration = durationSeconds;
        this.distance = distanceMeters;
        this.fare = fare;
    }
}
