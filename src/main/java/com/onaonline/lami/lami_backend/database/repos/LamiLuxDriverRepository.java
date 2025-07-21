package com.onaonline.lami.lami_backend.database.repos;

import com.onaonline.lami.lami_backend.database.details.LamiDriverDetails;
import com.onaonline.lami.lami_backend.database.details.LamiLuxDriverDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LamiLuxDriverRepository extends JpaRepository<LamiLuxDriverDetails, Long> {
    List<LamiLuxDriverDetails> findByLatitudeBetweenAndLongitudeBetween(double latMin, double latMax, double lonMin, double lonMax);

}
