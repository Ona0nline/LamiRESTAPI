package com.onaonline.lami.lami_backend.data.repos;

import com.onaonline.lami.lami_backend.data.LamiDriverDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LamiDriverRepository extends JpaRepository<LamiDriverDetails, Long> {
//    List<LamiDriverDetails> findByDriverId(Long driverId);
//    List because I expect to find multiple drivers with this location
    List<LamiDriverDetails> findByLocationAndAvailiable(String location, boolean availiable);
}
