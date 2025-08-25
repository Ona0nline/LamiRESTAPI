package com.onaonline.lami.lami_backend.database.repos;

import com.onaonline.lami.lami_backend.database.details.TaxiRanks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaxiRankRepository extends JpaRepository<TaxiRanks, Long> {
    List<TaxiRanks> findByLatitudeBetweenAndLongitudeBetween(double latMin, double latMax, double longMin, double longMax);

    Optional<TaxiRanks> findByName(String taxiRankName);

    @Query("SELECT t FROM TaxiRanks t LEFT JOIN FETCH t.routes WHERE t.id = :id")
    TaxiRanks findByIdWithRoutes(@Param("id") Long id);

    TaxiRanks findTaxiRanksById(Long rank_id);

}
