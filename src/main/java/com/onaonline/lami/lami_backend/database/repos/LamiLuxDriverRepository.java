package com.onaonline.lami.lami_backend.database.repos;

import com.onaonline.lami.lami_backend.database.details.LamiLuxDriverDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LamiLuxDriverRepository extends JpaRepository<LamiLuxDriverDetails, Long> {
//    List<LamiLuxDriverDetails> findByid(double latMin, double latMax, double lonMin, double lonMax, boolean available);

}
