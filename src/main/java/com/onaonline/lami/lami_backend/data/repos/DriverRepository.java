package com.onaonline.lami.lami_backend.data.repos;

import com.onaonline.lami.lami_backend.data.DriverDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<DriverDetails, Long> {
}
