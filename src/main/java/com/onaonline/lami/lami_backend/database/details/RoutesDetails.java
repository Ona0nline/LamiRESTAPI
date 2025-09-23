package com.onaonline.lami.lami_backend.database.details;

import com.onaonline.lami.lami_backend.util.LatLng;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

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

    @CollectionTable(name = "route_path_points", joinColumns = @JoinColumn(name = "route_id"))
    @ElementCollection(fetch = FetchType.EAGER)
    private List<LatLng> linespath;
    private double fare;

//    public RoutesDetails(Long rankId, String startLocation, String endLocation, double fare) {
//        this.rankId = rankId;
//        this.startLocation = startLocation;
//        this.endLocation = endLocation;
//        this.fare = fare;
//    }


//    public RoutesDetails(long l, String mtnTaxiRank, double v, double v1, String sowetoBara, double v2, double v3, int i, List<Double[]> linespath) {
//    }


    public RoutesDetails(Long rankId, String startLocation, double startLat, double startLong, String endLocation, double endLat, double endLong, double fare, List<LatLng> linespath) {
        this.rankId = rankId;
        this.startLocation = startLocation;
        this.startLat = startLat;
        this.startLong = startLong;
        this.endLocation = endLocation;
        this.endLat = endLat;
        this.endLong = endLong;
        this.fare = fare;
        this.linespath = linespath;

    }
}
