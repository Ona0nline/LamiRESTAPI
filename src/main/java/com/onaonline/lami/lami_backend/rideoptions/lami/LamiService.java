package com.onaonline.lami.lami_backend.rideoptions.lami;

import com.onaonline.lami.lami_backend.data.LamiDriverDetails;
import com.onaonline.lami.lami_backend.data.LamiLuxDriverDetails;
import com.onaonline.lami.lami_backend.data.repos.LamiDriverRepository;
import com.onaonline.lami.lami_backend.data.repos.LamiLuxDriverRepository;
import com.onaonline.lami.lami_backend.rideoptions.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LamiService {

    private Ride ride;
    @Autowired
    private LamiDriverRepository lamiDriverRepository;

    public List<Map<String, Object>> displayavailablerides(String startlocation, String endlocation) {

        List<LamiDriverDetails> nearbyDrivers = lamiDriverRepository.findByLocationAndAvailiable(startlocation, true);
        ArrayList<Map<String, Object>> availabledrivers = new ArrayList<>();

        if(!nearbyDrivers.isEmpty()){

            for (LamiDriverDetails driver : nearbyDrivers) {
                availabledrivers.add(Map.of(
                        "drivername", driver.getDrivername(),
                        "car",driver.getCar(),
                        "licensePlate",driver.getLicense_plate(),
                        "location",driver.getLocation(),
                        "fare","R50"
                ));
            }
        }

//        ride.setStartLocation(startlocation);
//        ride.setEndLocation(endlocation);
//        Updating driverid, license plate id,ride status and fare
//        Should only happen once ride is chosen
//        I want to take ride request details in, and 1st search for drivers that are in that area
//        <Optional> Then if found, return those drivers details as a json object
        return availabledrivers;
    }

    public void addride(){
//        Logic to add ride to database
    }

}
