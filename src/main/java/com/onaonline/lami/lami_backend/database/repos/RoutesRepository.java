package com.onaonline.lami.lami_backend.database.repos;

import com.onaonline.lami.lami_backend.database.details.RoutesDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutesRepository extends JpaRepository<RoutesDetails, Long> {
}
