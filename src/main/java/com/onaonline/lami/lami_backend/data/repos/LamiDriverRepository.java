package com.onaonline.lami.lami_backend.data.repos;

import com.onaonline.lami.lami_backend.data.details.LamiDriverDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LamiDriverRepository extends JpaRepository<LamiDriverDetails, Long> {
//    List<LamiDriverDetails> findByDriverId(Long driverId);
//    List because I expect to find multiple drivers with this location
//    List<LamiDriverDetails> findByLocationAndAvailiable(double latitude, double longitude, boolean availiable);
    List<LamiDriverDetails> findByLatitudeBetweenAndLongitudeBetweenAndAvailiable(double latMin, double latMax, double lonMin, double lonMax, boolean available);
}
