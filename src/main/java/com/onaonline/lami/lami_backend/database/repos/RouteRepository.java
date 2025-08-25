package com.onaonline.lami.lami_backend.database.repos;

import com.onaonline.lami.lami_backend.database.details.Route;
import com.onaonline.lami.lami_backend.database.details.TaxiRanks;
import org.geolatte.geom.LineString;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {


    @Query(
                    value = """
        SELECT rank_id
        FROM route 
        WHERE ST_Contains(
                  coordinates, 
                  ST_SetSRID(ST_Point(:lon, :lat), 4326)
              )
           OR ST_DWithin(
                  coordinates::geography, 
                  ST_SetSRID(ST_Point(:lon, :lat), 4326)::geography, 
                  1000
              )
        """,
                    nativeQuery = true

    )
    List<Long> findRouteIdsContainingPoint(@Param("lon") double lon, @Param("lat") double lat);

    @Query(
            value = "SELECT coordinates FROM route WHERE ST_Contains(coordinates, T_Contains(\n" +
                    "                  coordinates, \n" +
                    "                  ST_SetSRID(ST_Point(:lon, :lat), 4326)\n" +
                    "              )) OR ST_DWithin(coordinates::geography, T_Contains(\n" +
                    "                  coordinates, \n" +
                    "                  ST_SetSRID(ST_Point(:lon, :lat), 4326)\n" +
                    "              )::geography, 1000)",
            nativeQuery = true
    )
    List<org.locationtech.jts.geom.LineString> findRoutesContainingPoint(@Param("lon") double lon, @Param("lat") double lat);

    void deleteAllByRankId(TaxiRanks taxiRank);
}
