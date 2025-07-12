package com.onaonline.lami.lami_backend.externalApis.distancematrix;

import lombok.Data;

@Data
public class DistanceMatrixRequestDTO {
    private String startLocation;
    private String endLocation;
    private String lat;
    private String lon;


}
