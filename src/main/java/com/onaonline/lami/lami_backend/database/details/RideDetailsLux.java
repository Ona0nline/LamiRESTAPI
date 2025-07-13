package com.onaonline.lami.lami_backend.database.details;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class RideDetailsLux {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String placename;
    public double latitude;
    public double longitude;
    public String fare;
    //    Relationship between tables
    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    public LamiLuxDriverDetails driver;

}
