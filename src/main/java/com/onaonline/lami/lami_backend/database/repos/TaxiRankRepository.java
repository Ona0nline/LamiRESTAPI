package com.onaonline.lami.lami_backend.database.repos;

import com.onaonline.lami.lami_backend.database.details.TaxiRankDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaxiRankRepository extends JpaRepository<TaxiRankDetails, Long> {
    List<TaxiRankDetails> findByLatitudeBetweenAndLongitudeBetween(double latMin, double latMax, double longMin, double longMax);

}
