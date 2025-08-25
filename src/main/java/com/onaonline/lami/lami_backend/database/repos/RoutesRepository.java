package com.onaonline.lami.lami_backend.database.repos;

import com.onaonline.lami.lami_backend.database.details.RoutesDetails;
import com.onaonline.lami.lami_backend.database.details.TaxiRanks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoutesRepository extends JpaRepository<RoutesDetails, Long> {
    List<RoutesDetails> findByRankId(Long rankId);
    void deleteAllByRankId(TaxiRanks rankId);
}
