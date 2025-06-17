package com.onaonline.lami.lami_backend.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DriverRepository extends JpaRepository<DriverDetails, Long> {
}
