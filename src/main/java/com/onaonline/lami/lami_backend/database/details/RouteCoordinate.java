package com.onaonline.lami.lami_backend.database.details;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RouteCoordinate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double lat;
    private Double lng;
    private Integer sequence;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

}
