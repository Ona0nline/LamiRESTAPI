package com.onaonline.lami.lami_backend.data.repos;

import com.onaonline.lami.lami_backend.data.details.LamiLuxDriverDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LamiLuxDriverRepository extends JpaRepository<LamiLuxDriverDetails, Long> {
}
