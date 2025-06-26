package com.onaonline.lami.lami_backend.data.repos;

import com.onaonline.lami.lami_backend.data.details.RideDetailsLux;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepositoryLux extends JpaRepository<RideDetailsLux, Long> {
}
