package com.onaonline.lami.lami_backend.database.details;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString(exclude = "routes")
public class TaxiRanks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double latitude;
    private double longitude;
    private String province;
    @OneToMany(mappedBy = "rankId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Route> routes;

    public TaxiRanks(String name, double latitude, double longitude, String province) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.province = province;
    }
}
