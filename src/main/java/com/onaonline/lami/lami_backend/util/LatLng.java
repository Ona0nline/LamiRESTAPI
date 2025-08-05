package com.onaonline.lami.lami_backend.util;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;

@Embeddable
@AllArgsConstructor
public class LatLng {
    private double lat;
    private double lon;

    public LatLng() {

    }
}
