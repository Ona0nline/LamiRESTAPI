package com.onaonline.lami.lami_backend.rideoptions.lux;

import com.onaonline.lami.lami_backend.externalApis.distancematrix.DistanceMatrixRequestDTO;
import com.onaonline.lami.lami_backend.externalApis.distancematrix.DistanceMatrixResponseDTO;
import com.onaonline.lami.lami_backend.externalApis.distancematrix.DistanceMatrixService;
import com.onaonline.lami.lami_backend.externalApis.geocoding.GeocodeResponseDTO;
import com.onaonline.lami.lami_backend.externalApis.geocoding.GeocodeService;
import com.onaonline.lami.lami_backend.rideoptions.lami.AvailableRidesResponseDTO;
import com.onaonline.lami.lami_backend.user.UserValidationService;
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
    private GeocodeService geocodeService;

    @Autowired
    private LuxuryService luxuryService;

    @Autowired
    private DistanceMatrixService distanceMatrixService;

    @PostMapping("/luxury/available-rides")
    public ResponseEntity<?> availabledrivers(@RequestBody DistanceMatrixRequestDTO distanceMatrixRequestDTO) throws Exception {
        DistanceMatrixResponseDTO distanceMatrixResponse = distanceMatrixService.distanceCalculator(distanceMatrixRequestDTO.getStartLocation(),distanceMatrixRequestDTO.getEndLocation());
        GeocodeResponseDTO geocodeResponseDTO = geocodeService.geocodeAddress(distanceMatrixRequestDTO.getStartLocation());
        System.out.println(geocodeResponseDTO);
        System.out.println("Lat: " + geocodeResponseDTO.getLatitude() + " And Long: " +geocodeResponseDTO.getLongitude());
        List<Map<String, Object>> results = luxuryService.displayavailablerides(geocodeResponseDTO.getLatitude(),geocodeResponseDTO.getLongitude());
        AvailableRidesResponseDTO availableRidesResponse = new AvailableRidesResponseDTO(distanceMatrixResponse,results);
        if (results.isEmpty()) return ResponseEntity.ok("List empty");
        return ResponseEntity.ok(availableRidesResponse);
    }


    @PostMapping("luxury/request-ride")
    public ResponseEntity<?> requestRide(@RequestBody Luxury luxury){
        return ResponseEntity.ok(luxuryService.bookride(luxury));
    }
}
