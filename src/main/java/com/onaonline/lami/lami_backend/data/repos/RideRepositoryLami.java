package com.onaonline.lami.lami_backend.data.repos;

import com.onaonline.lami.lami_backend.data.details.RideDetailsLami;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepositoryLami extends JpaRepository<RideDetailsLami, Long> {
}
