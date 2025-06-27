package com.onaonline.lami.lami_backend.rideoptions.lami;

import com.onaonline.lami.lami_backend.data.details.LamiDriverDetails;
import com.onaonline.lami.lami_backend.data.details.RideDetailsLami;
import com.onaonline.lami.lami_backend.data.repos.LamiDriverRepository;
import com.onaonline.lami.lami_backend.data.repos.RideRepositoryLami;
import com.onaonline.lami.lami_backend.util.BoundingBox;
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
    private RideRepositoryLami rideRepositoryLami;
    private BoundingBox boundingBox;

    public List<Map<String, Object>> displayavailablerides(double startLocationLat,double startLocationLong, double endLocationLat, double endLocationLong) {

        BoundingBox boundingBox1 = boundingBox.calculateBoundingBox(startLocationLat,startLocationLong,12.5);
        List<LamiDriverDetails> nearbyDrivers = lamiDriverRepository.findByLatitudeBetweenAndLongitudeBetweenAndAvailiable(boundingBox1.latMin,
                boundingBox1.latMax, boundingBox1.lonMin, boundingBox1.lonMax, true);

//Need to figure out how "close" drivers are based off of
//        double circle_distance = haversine(startLocationLat,startLocationLong)

        ArrayList<Map<String, Object>> availabledrivers = new ArrayList<>();

        if(!nearbyDrivers.isEmpty()){
            for (LamiDriverDetails driver : nearbyDrivers) {
                availabledrivers.add(Map.of(
                        "id", driver.getId(),
                        "drivername", driver.getDrivername(),
                        "licensePlate",driver.getLicense_plate(),
                        "latitude",driver.getLatitude(),
                        "longitude", driver.getLongitude(),
                        "placeName", driver.getPlaceName(),
                        "fare","R50"
                ));
            }
        }

        return availabledrivers;
    }


    public RideDetailsLami bookride(Lami lami) {

        if (lami.getDriverid() == null) {
            throw new RuntimeException("Driver ID is missing from the request.");
        }
        LamiDriverDetails driver = lamiDriverRepository.findById(lami.getDriverid())
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        RideDetailsLami confirmedRide = RideDetailsLami.builder()
                .startLocation(lami.getStartLocation())
                .endLocation(lami.getEndLocation())
                .fare("R" + lami.getFare())
                .driver(driver)
                .build();

        rideRepositoryLami.save(confirmedRide);
        return confirmedRide;

    }

//    Haversine method is used to calculate the great circle distance between two points
    public static double haversine(double userlat, double userlon, double driverlat, double driverlon) {
        final int R = 6371; // Earth radius in km

        double latDistance = Math.toRadians(driverlat - userlat);
        double lonDistance = Math.toRadians(driverlon - userlon);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(userlat)) * Math.cos(Math.toRadians(driverlat))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c; // Distance in kilometers
    }

}
