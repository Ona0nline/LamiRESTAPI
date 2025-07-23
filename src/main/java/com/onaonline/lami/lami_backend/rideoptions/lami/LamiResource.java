package com.onaonline.lami.lami_backend.rideoptions.lami;

import com.onaonline.lami.lami_backend.database.details.RideDetailsLami;
import com.onaonline.lami.lami_backend.externalApis.distancematrix.DistanceMatrixRequestDTO;
import com.onaonline.lami.lami_backend.externalApis.distancematrix.DistanceMatrixResponseDTO;
import com.onaonline.lami.lami_backend.externalApis.distancematrix.DistanceMatrixService;
import com.onaonline.lami.lami_backend.externalApis.geocoding.GeocodeResponseDTO;
import com.onaonline.lami.lami_backend.externalApis.geocoding.GeocodeService;
import com.onaonline.lami.lami_backend.rideoptions.Ride;
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

    @Autowired
    private GeocodeService geocodeService;

    @Autowired
    private DistanceMatrixService distanceMatrixService;

//    session attribute stuff should move here too

    @PostMapping("/lami/available-rides")
    public ResponseEntity<Object> availablerides(@RequestBody DistanceMatrixRequestDTO distanceMatrixRequestDTO) throws Exception {
//        Ride response for user (Distance, duration, fare)
//        also need to return how far away the driver is away from youuu
        DistanceMatrixResponseDTO distanceMatrixResponse = distanceMatrixService.distanceCalculator(distanceMatrixRequestDTO.getStartLocation(),distanceMatrixRequestDTO.getEndLocation());
        GeocodeResponseDTO geocodeResponseDTO = geocodeService.geocodeAddress(distanceMatrixRequestDTO.getStartLocation());
        System.out.println(geocodeResponseDTO);
        List<Map<String, Object>> results = lamiService.displayavailablerides(geocodeResponseDTO.getLatitude(),geocodeResponseDTO.getLongitude());
        AvailableRidesResponseDTO availableRidesResponse = new AvailableRidesResponseDTO(distanceMatrixResponse,results);
        if (results.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(availableRidesResponse);
    }


    @PostMapping("/lami/request-ride")
    public ResponseEntity<RideDetailsLami> requestride(@RequestBody Lami lami) {
//        Store the ride that person requested in a session attribute, and access it from there to cancel
//        New Ride details will include start and end location details to be editted
        return ResponseEntity.ok(lamiService.bookride(lami));
    }



}
