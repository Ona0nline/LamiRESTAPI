package com.onaonline.lami.lami_backend.database.details;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.locationtech.jts.geom.LineString;


@Entity
@Data
@AllArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//Will come from first value (list) from routes object, name might just need to go...
    private int weight;
    private int duration;
    private int distance;
    @ManyToOne
    @JoinColumn(name = "rank_id")
    private TaxiRanks rankId;

    @Column(columnDefinition = "geometry(LineString, 4326)")
    private LineString coordinates;

    public Route(int weight, int distance, int duration, LineString coordinates, TaxiRanks rankId) {
        this.weight = weight;
        this.distance = distance;
        this.duration = duration;
        this.coordinates = coordinates;
        this.rankId = rankId;
    }

    public Route(int weight, int distance, int duration, LineString routeCoords) {
        this.weight = weight;
        this.distance = distance;
        this.duration = duration;
        this.coordinates = routeCoords;
    }

    public Route() {

    }
}
