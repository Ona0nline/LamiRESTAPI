package com.onaonline.lami.lami_backend.rideoptions.lux;

import com.onaonline.lami.lami_backend.data.details.LamiLuxDriverDetails;
import com.onaonline.lami.lami_backend.data.details.RideDetailsLux;
import com.onaonline.lami.lami_backend.data.repos.LamiLuxDriverRepository;
import com.onaonline.lami.lami_backend.data.repos.RideRepositoryLami;
import com.onaonline.lami.lami_backend.data.repos.RideRepositoryLux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LuxuryService {

    @Autowired
    private LamiLuxDriverRepository lamiLuxDriverRepository;

    @Autowired
    private RideRepositoryLux rideRepositoryLux;

    public List<Map<String, Object>> displayavailablerides(String startlocation, String endLocation) {
//End location param has secret purpose in frontend
        List<LamiLuxDriverDetails> nearbyDrivers = lamiLuxDriverRepository.findByLocationAndAvailiable(startlocation, true);
        ArrayList<Map<String, Object>> availabledrivers = new ArrayList<>();

        if(!nearbyDrivers.isEmpty()){
            for (LamiLuxDriverDetails driver : nearbyDrivers) {
                availabledrivers.add(Map.of(
                        "id", driver.getId(),
                        "drivername", driver.getDrivername(),
                        "licensePlate",driver.getLicense_plate(),
                        "location",driver.getLocation(),
                        "fare","R50"
                ));
            }
        }

        return availabledrivers;
    }


    public RideDetailsLux bookride(Luxury luxury) {

        if (luxury.getDriverid() == null) {
            throw new RuntimeException("Driver ID is missing from the request.");
        }
        LamiLuxDriverDetails luxdriver = lamiLuxDriverRepository.findById(luxury.getDriverid())
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        RideDetailsLux confirmedRide = RideDetailsLux.builder().startLocation(luxury.getStartLocation())
                        .endLocation(luxury.getEndLocation()).
                        fare("R" + luxury.getFare()).
                        driver(luxdriver).build();

        rideRepositoryLux.save(confirmedRide);
        return confirmedRide;

    }
}
