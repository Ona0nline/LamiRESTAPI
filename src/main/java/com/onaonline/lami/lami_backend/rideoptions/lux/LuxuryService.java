package com.onaonline.lami.lami_backend.rideoptions.lux;

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
    private BoundingBox boundingBox;

    @Autowired
    private LamiLuxDriverRepository lamiLuxDriverRepository;

    @Autowired
    private RideRepositoryLux rideRepositoryLux;

    public List<Map<String, Object>> displayavailablerides(Long id) {

//        This desn't make sense lowkey because where are you gonna see a Rolls Royce randomly hanging around?
//        LamiLux on pause for now
//        BoundingBox boundingBox1 = boundingBox.calculateBoundingBox(startLocationLat,startLocationLong,12.5);
        Optional<LamiLuxDriverDetails> nearbyDrivers = lamiLuxDriverRepository.findById(id);
        List<LamiLuxDriverDetails> drvers = nearbyDrivers.stream().toList();

//Need to figure out how "close" drivers are based off of
//        double circle_distance = haversine(startLocationLat,startLocationLong)

        ArrayList<Map<String, Object>> availabledrivers = new ArrayList<>();

        if(nearbyDrivers.isPresent()){
            for (LamiLuxDriverDetails driver : drvers) {
                availabledrivers.add(Map.of(
                        "id", driver.getId(),
                        "drivername", driver.getDrivername(),
                        "licensePlate",driver.getLicense_plate(),
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

        RideDetailsLux confirmedRide = RideDetailsLux.builder()
                        .placename(luxury.getPlacename())
                                .latitude(luxury.getLatitude())
                                        .longitude(luxury.getLongitude())
                .fare("R" + luxury.getFare()).
                        driver(luxdriver).build();

        rideRepositoryLux.save(confirmedRide);
        return confirmedRide;

    }
}
