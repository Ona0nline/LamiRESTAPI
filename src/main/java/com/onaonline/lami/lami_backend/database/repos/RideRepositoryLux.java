package com.onaonline.lami.lami_backend.database.repos;

import com.onaonline.lami.lami_backend.database.details.RideDetailsLami;
import com.onaonline.lami.lami_backend.database.details.RideDetailsLux;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RideRepositoryLux extends JpaRepository<RideDetailsLux, Long> {
    List<RideDetailsLux> findByEmail(String email);
}
