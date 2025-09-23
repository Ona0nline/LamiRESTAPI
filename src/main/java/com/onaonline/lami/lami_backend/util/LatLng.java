package com.onaonline.lami.lami_backend.util;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Embeddable
@AllArgsConstructor
@Data
public class LatLng {
    public double v;
    private double v1;
    public LatLng() {
    }

}
