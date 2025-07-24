package com.onaonline.lami.lami_backend.rideoptions.lami;

import com.onaonline.lami.lami_backend.database.details.LamiDriverDetails;
import com.onaonline.lami.lami_backend.database.details.RideDetailsLami;
import com.onaonline.lami.lami_backend.database.repos.LamiDriverRepository;
import com.onaonline.lami.lami_backend.database.repos.RideRepositoryLami;
import com.onaonline.lami.lami_backend.util.BoundingBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LamiService {

    @Autowired
    private  LamiDriverRepository lamiDriverRepository;
    @Autowired
    private RideRepositoryLami rideRepositoryLami;
    private final BoundingBox boundingBox = new BoundingBox();


    public List<Map<String, Object>> displayavailablerides(double startLocationLat, double startLocationLong) {

        BoundingBox boundingBox1 = boundingBox.calculateBoundingBox(startLocationLat,startLocationLong,12.5);
        List<LamiDriverDetails> nearbyDrivers = lamiDriverRepository.findByLatitudeBetweenAndLongitudeBetweenAndAvailiable(boundingBox1.latMin,
                boundingBox1.latMax, boundingBox1.lonMin, boundingBox1.lonMax, true);

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
                        "perks", driver.getPerks()
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

//        Fix this to store start and end location WITH lat and long instead of placename
        RideDetailsLami confirmedRide = RideDetailsLami.builder().
                placename(driver.getPlaceName()).latitude(driver.getLatitude())
                .longitude(driver.getLongitude())
                .driver(driver)
                .build();

        rideRepositoryLami.save(confirmedRide);
        return confirmedRide;

    }

    public String cancelRide(Long id){

        Optional<RideDetailsLami> optionalRideDetailsLami = rideRepositoryLami.findById(id);
        if(optionalRideDetailsLami.isPresent()){
            Long foundRide = optionalRideDetailsLami.get().id;
            rideRepositoryLami.deleteById(foundRide);
            return "Ride successfully cancelled";
        }
            return "Ride was not requested";

    }


    public String editRide(String newStartLocation, String newEndLocation, RideDetailsLami requestedRide) {
        Optional<RideDetailsLami> optionalRideDetailsLami = rideRepositoryLami.findById(requestedRide.id);

        if(optionalRideDetailsLami.isPresent()){
            RideDetailsLami databaseRideDetails = optionalRideDetailsLami.get();
            databaseRideDetails.startLocation = newStartLocation;
            databaseRideDetails.endLocation = newEndLocation;
            rideRepositoryLami.save(databaseRideDetails);
            return "Location successfully updated";
        }
        return "Ride was not requested";
    }
}
