package com.onaonline.lami.lami_backend.database.repos;

import com.onaonline.lami.lami_backend.database.details.RideDetailsLami;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RideRepositoryLami extends JpaRepository<RideDetailsLami, Long> {
    List<RideDetailsLami> findByEmail(String email);
}
