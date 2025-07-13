package com.onaonline.lami.lami_backend.database.repos;

import com.onaonline.lami.lami_backend.database.details.RideDetailsLux;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepositoryLux extends JpaRepository<RideDetailsLux, Long> {
}
