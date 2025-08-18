package com.onaonline.lami.lami_backend.database.repos;

import com.onaonline.lami.lami_backend.database.details.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
}
