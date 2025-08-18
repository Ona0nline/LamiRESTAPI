package com.onaonline.lami.lami_backend.database.details;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//Will come from first value (list) from routes object, name might just need to go...
    private String name;
    private Double weight;
    private Double duration;
    private Double distance;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RouteCoordinate> coordinates = new ArrayList<>();

}
