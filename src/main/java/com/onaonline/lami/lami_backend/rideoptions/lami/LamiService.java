package com.onaonline.lami.lami_backend.rideoptions.lami;

import com.onaonline.lami.lami_backend.data.LamiDriverDetails;
import com.onaonline.lami.lami_backend.data.RideDetails;
import com.onaonline.lami.lami_backend.data.repos.LamiDriverRepository;
import com.onaonline.lami.lami_backend.data.repos.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LamiService {

    @Autowired
    private LamiDriverRepository lamiDriverRepository;
    @Autowired
    private RideRepository rideRepository;

    public List<Map<String, Object>> displayavailablerides(String startlocation, String endLocation) {
//End location param has secret purpose in frontend
        List<LamiDriverDetails> nearbyDrivers = lamiDriverRepository.findByLocationAndAvailiable(startlocation, true);
        ArrayList<Map<String, Object>> availabledrivers = new ArrayList<>();

        if(!nearbyDrivers.isEmpty()){
            for (LamiDriverDetails driver : nearbyDrivers) {
                availabledrivers.add(Map.of(
                        "id", driver.getId(),
                        "drivername", driver.getDrivername(),
                        "car",driver.getCar(),
                        "licensePlate",driver.getLicense_plate(),
                        "location",driver.getLocation(),
                        "fare","R50"
                ));
            }
        }

        return availabledrivers;
    }


    public RideDetails bookride(Lami lami) {

        if (lami.getDriverid() == null) {
            throw new RuntimeException("Driver ID is missing from the request.");
        }
        LamiDriverDetails driver = lamiDriverRepository.findById(lami.getDriverid())
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        RideDetails confirmedRide = RideDetails.builder()
                .startLocation(lami.getStartLocation())
                .endLocation(lami.getEndLocation())
                .fare("R" + lami.getFare())
                .driver(driver)
                .build();

        rideRepository.save(confirmedRide);
        return confirmedRide;

    }
}
