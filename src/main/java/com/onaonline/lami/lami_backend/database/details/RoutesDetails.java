package com.onaonline.lami.lami_backend.database.details;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
public class RoutesDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long rankId;
    private String startLocation;
    private double startLat;
    private double startLong;
    private String endLocation;
    private double endLat;
    private double endLong;

    private double fare;

//    public RoutesDetails(Long rankId, String startLocation, String endLocation, double fare) {
//        this.rankId = rankId;
//        this.startLocation = startLocation;
//        this.endLocation = endLocation;
//        this.fare = fare;
//    }


    public RoutesDetails(long l, String mtnTaxiRank, double v, double v1, String sowetoBara, double v2, double v3, int i) {
    }
}
