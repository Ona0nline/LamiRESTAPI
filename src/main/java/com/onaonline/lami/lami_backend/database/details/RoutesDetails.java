package com.onaonline.lami.lami_backend.database.details;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class RoutesDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long rankId;
    private String startLocation;
    private String endLocation;
    private double fare;

    public RoutesDetails(Long rankId, String startLocation, String endLocation, double fare) {
        this.rankId = rankId;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.fare = fare;
    }
}
