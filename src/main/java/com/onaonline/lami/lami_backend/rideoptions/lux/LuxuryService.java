package com.onaonline.lami.lami_backend.rideoptions.lux;

import com.onaonline.lami.lami_backend.database.details.LamiDriverDetails;
import com.onaonline.lami.lami_backend.database.details.LamiLuxDriverDetails;
import com.onaonline.lami.lami_backend.database.details.RideDetailsLux;
import com.onaonline.lami.lami_backend.database.repos.LamiLuxDriverRepository;
import com.onaonline.lami.lami_backend.database.repos.RideRepositoryLux;
import com.onaonline.lami.lami_backend.util.BoundingBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LuxuryService {
    private final BoundingBox boundingBox = new BoundingBox();

    @Autowired
    private LamiLuxDriverRepository lamiLuxDriverRepository;

    @Autowired
    private RideRepositoryLux rideRepositoryLux;

    public List<Map<String, Object>> displayavailablerides(double startLocationLat, double startLocationLong) {

        BoundingBox boundingBox1 = boundingBox.calculateBoundingBox(startLocationLat,startLocationLong,12.5);
        List<LamiLuxDriverDetails> nearbyDrivers = lamiLuxDriverRepository.
                findByLatitudeBetweenAndLongitudeBetween(boundingBox1.latMin,
                boundingBox1.latMax, boundingBox1.lonMin, boundingBox1.lonMax);

        System.out.println("Available drivers: " + nearbyDrivers);

        ArrayList<Map<String, Object>> availabledrivers = new ArrayList<>();
        if(!nearbyDrivers.isEmpty()){
            for (LamiLuxDriverDetails driver : nearbyDrivers) {
                availabledrivers.add(Map.of(
                        "id", driver.getId(),
                        "drivername", driver.getDrivername(),
                        "licensePlate",driver.getLicense_plate(),
                        "latitude",driver.getLatitude(),
                        "longitude", driver.getLongitude(),
                        "placename", driver.getPlacename(),
                        "qualification",driver.getDriverlevel(),
                        "perks",driver.getPerks(),
                        "car",driver.getCar(),
                        "fare", driver.getFare()
                ));
            }
        }
        System.out.println("No nearby drivers");

        return availabledrivers;

    }


    public RideDetailsLux bookride(Long id, String start, String end, double fare) {

        LamiLuxDriverDetails luxdriver = lamiLuxDriverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        double totalFare = fare + luxdriver.getFare();
        RideDetailsLux confirmedRide = RideDetailsLux.builder()
                                .latitude(luxdriver.getLatitude())
                                .longitude(luxdriver.getLongitude())
                                .startLocation(start)
                                .endLocation(end)
                                .totalfare(totalFare)
                                .driver(luxdriver)
                                .build();

        rideRepositoryLux.save(confirmedRide);
        return confirmedRide;

    }
}
