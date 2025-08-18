package com.onaonline.lami.lami_backend.database.repos;

import com.onaonline.lami.lami_backend.database.details.RouteCoordinate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteCoordinateRepository extends JpaRepository<RouteCoordinate, Long> {
}
