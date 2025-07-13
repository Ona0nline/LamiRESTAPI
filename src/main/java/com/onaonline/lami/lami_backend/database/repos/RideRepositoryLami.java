package com.onaonline.lami.lami_backend.database.repos;

import com.onaonline.lami.lami_backend.database.details.RideDetailsLami;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepositoryLami extends JpaRepository<RideDetailsLami, Long> {
}
