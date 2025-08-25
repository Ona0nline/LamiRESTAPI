package com.onaonline.lami.lami_backend.externalApis.osrm;

import com.onaonline.lami.lami_backend.database.details.TaxiRanks;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.LineString;

@Data
@AllArgsConstructor
public class OsrmMetaData {
    private int weight;
    private  int duration;
    private  int distance;
    private LineString routeCoords;
    private TaxiRanks taxiRank;

    public OsrmMetaData(int weight, int duration, int distance, LineString routeCoords) {
        this.weight = weight;
        this.duration = duration;
        this.distance = distance;
        this.routeCoords = routeCoords;
    }
}
