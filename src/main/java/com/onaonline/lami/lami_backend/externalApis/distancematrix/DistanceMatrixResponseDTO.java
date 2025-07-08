package com.onaonline.lami.lami_backend.externalApis.distancematrix;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class DistanceMatrixResponseDTO {
    private double duration;
    private double distance;
    private String fare;


}
