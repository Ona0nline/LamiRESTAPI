package com.onaonline.lami.lami_backend.rideoptions.lux;

import com.onaonline.lami.lami_backend.home.UserValidationService;
import com.onaonline.lami.lami_backend.rideoptions.Ride;
import com.onaonline.lami.lami_backend.rideoptions.RideRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class LuxResource extends Ride {

    @Autowired
    private UserValidationService userValidationService;

    @Autowired
    private LuxuryService luxuryService;

    @PostMapping("/luxury/available-rides")
    public ResponseEntity<?> availabledrivers(@RequestBody RideRequestDTO rideRequestDTO){
        List<Map<String, Object>> available_drivers = luxuryService.displayavailablerides(rideRequestDTO.getId());
        if(available_drivers.isEmpty()){
            return ResponseEntity.ok("No available drivers");
        }
        return ResponseEntity.ok(available_drivers);
    }


    @PostMapping("luxury/request-ride")
    public ResponseEntity<?> requestRide(@RequestBody Luxury luxury){
        return ResponseEntity.ok(luxuryService.bookride(luxury));
    }
}
