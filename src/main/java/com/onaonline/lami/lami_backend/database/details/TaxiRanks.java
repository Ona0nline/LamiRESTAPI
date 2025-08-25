package com.onaonline.lami.lami_backend.database.details;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class TaxiRanks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double latitude;
    private double longitude;
    private String province;

    public TaxiRanks(String name, double latitude, double longitude, String province) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.province = province;
    }
}
