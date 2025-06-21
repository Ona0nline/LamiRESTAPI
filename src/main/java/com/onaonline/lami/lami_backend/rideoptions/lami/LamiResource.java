package com.onaonline.lami.lami_backend.rideoptions.lami;

import com.onaonline.lami.lami_backend.data.RideDetails;
import com.onaonline.lami.lami_backend.data.UserDetails;
import com.onaonline.lami.lami_backend.home.UserValidation;
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
public class LamiResource extends Ride {

    @Autowired
    private LamiService lamiService;

    @PostMapping("/lami/available-rides")
    public ResponseEntity<Object> availablerides(@RequestBody RideRequestDTO rideRequest) {
        List<Map<String, Object>> results = lamiService.displayavailablerides(rideRequest.getStartLocation(), rideRequest.getEndLocation());
        if (results.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(results);
    }


    @PostMapping("/lami/request-ride")
    public ResponseEntity<RideDetails> requestride(@RequestBody Lami lami) {
        return ResponseEntity.ok(lamiService.bookride(lami));
    }


}
