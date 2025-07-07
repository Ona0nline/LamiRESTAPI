package com.onaonline.lami.lami_backend.rideoptions.lami;

import com.onaonline.lami.lami_backend.data.details.RideDetailsLami;
import com.onaonline.lami.lami_backend.externalApis.geocoding.GeocodeRequestDTO;
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

    @PostMapping("/lami/available-rides")
    public ResponseEntity<Object> availablerides(@RequestBody GeocodeRequestDTO geocodeRequestDTO) throws Exception {

        GeocodeResponseDTO geocodeResponseDTO = geocodeService.geocodeAddress(geocodeRequestDTO.getAddress());
        System.out.println(geocodeResponseDTO);
        List<Map<String, Object>> results = lamiService.displayavailablerides(geocodeResponseDTO.getLatitude(),geocodeResponseDTO.getLongitude());
        if (results.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(results);
    }


    @PostMapping("/lami/request-ride")
    public ResponseEntity<RideDetailsLami> requestride(@RequestBody Lami lami) {
        return ResponseEntity.ok(lamiService.bookride(lami));
    }

//    Start location input from user
    @PostMapping("/lami/startLocation")
    public ResponseEntity<?> startLocation(@RequestBody GeocodeRequestDTO geocodeRequestDTO) throws Exception {
        return ResponseEntity.ok(geocodeService.geocodeAddress(geocodeRequestDTO.getAddress()));
    }

    @PostMapping("/lami/endLocation")
    public ResponseEntity<?> endLocation(@RequestBody GeocodeRequestDTO geocodeRequestDTO) throws Exception {
        GeocodeResponseDTO geocodeResponseDTO = geocodeService.geocodeAddress(geocodeRequestDTO.getAddress());

        return ResponseEntity.ok(geocodeService.geocodeAddress(geocodeRequestDTO.getAddress()));
    }


}
