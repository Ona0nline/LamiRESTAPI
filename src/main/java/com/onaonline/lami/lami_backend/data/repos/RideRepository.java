package com.onaonline.lami.lami_backend.data.repos;

import com.onaonline.lami.lami_backend.data.details.RideDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<RideDetails, Long> {
}
