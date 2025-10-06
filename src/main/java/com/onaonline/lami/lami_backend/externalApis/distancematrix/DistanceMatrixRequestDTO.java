package com.onaonline.lami.lami_backend.externalApis.distancematrix;

import lombok.Data;

@Data
public class DistanceMatrixRequestDTO {
    private String startAddress;
    private String endAddress;
    private double startLatitude;
    private double startLongitude;
//    private double luxFare;


}
