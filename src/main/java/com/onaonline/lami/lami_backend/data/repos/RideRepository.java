package com.onaonline.lami.lami_backend.data.repos;

import com.onaonline.lami.lami_backend.data.RideDetails;
import com.onaonline.lami.lami_backend.rideoptions.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<RideDetails, Long> {
}
