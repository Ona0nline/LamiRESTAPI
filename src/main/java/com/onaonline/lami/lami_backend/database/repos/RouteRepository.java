package com.onaonline.lami.lami_backend.database.repos;

import com.onaonline.lami.lami_backend.database.details.Route;
import org.geolatte.geom.LineString;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    @Query(
            value = "SELECT id FROM routes WHERE ST_Contains(geom, point) OR ST_DWithin(geom::geography, point::geography, 1000)",
            nativeQuery = true
    )
    List<Long> findRouteIdsContainingPoint(@Param("lon") double lon, @Param("lat") double lat);

    @Query(
            value = "SELECT coords FROM routes WHERE ST_Contains(geom, point) OR ST_DWithin(geom::geography, point::geography, 1000)",
            nativeQuery = true
    )
    List<org.locationtech.jts.geom.LineString> findRoutesContainingPoint(@Param("lon") double lon, @Param("lat") double lat);

}
