package com.onaonline.lami.lami_backend.externalApis.geocoding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class GeocodeResponseDTO {
    private String formattedAddress;
    private double latitude;
    private double longitude;
}
