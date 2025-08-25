package com.onaonline.lami.lami_backend.database.repos;

import com.onaonline.lami.lami_backend.database.details.TaxiRanks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.ScopedValue;
import java.util.List;
import java.util.Optional;

public interface TaxiRankRepository extends JpaRepository<TaxiRanks, Long> {
    List<TaxiRanks> findByLatitudeBetweenAndLongitudeBetween(double latMin, double latMax, double longMin, double longMax);

    Optional<TaxiRanks> findByName(String taxiRankName);
}
