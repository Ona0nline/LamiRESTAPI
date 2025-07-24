package com.onaonline.lami.lami_backend.rideoptions.lami;

import com.onaonline.lami.lami_backend.externalApis.distancematrix.DistanceMatrixResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class AvailableRidesResponseDTO {

    private DistanceMatrixResponseDTO distanceMatrixResponseDTO;
    private List<Map<String, Object>> nearbyDrivers;
    private String userStart;
    private String userEnd;
}
