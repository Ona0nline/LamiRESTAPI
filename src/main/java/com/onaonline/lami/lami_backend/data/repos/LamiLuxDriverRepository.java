package com.onaonline.lami.lami_backend.data.repos;

import com.onaonline.lami.lami_backend.data.details.LamiDriverDetails;
import com.onaonline.lami.lami_backend.data.details.LamiLuxDriverDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LamiLuxDriverRepository extends JpaRepository<LamiLuxDriverDetails, Long> {
//    List<LamiLuxDriverDetails> findByid(double latMin, double latMax, double lonMin, double lonMax, boolean available);

}
