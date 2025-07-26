package com.onaonline.lami.lami_backend.rideoptions.lux;

import com.onaonline.lami.lami_backend.externalApis.distancematrix.DistanceMatrixLuxResponseDTO;
import com.onaonline.lami.lami_backend.externalApis.distancematrix.DistanceMatrixResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class AvailableRidesLuxResponseDTO {
    private DistanceMatrixLuxResponseDTO distanceMatrixLuxResponseDTO;
    private List<Map<String, Object>> nearbyDrivers;
    private String userStart;
    private String userEnd;
}
