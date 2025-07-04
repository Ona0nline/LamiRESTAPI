package com.onaonline.lami.lami_backend.externalApis;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeocodeResource {

    @Autowired
    private GeocodeService geocodeService;

    public GeocodeResource(GeocodeService geocodeService) {
        this.geocodeService = geocodeService;
    }

    @PostMapping("/api/geocode")
    public ResponseEntity<?> getCoordinates(@RequestBody GeocodeRequestDTO geocodeRequestDTO) throws Exception {
        return ResponseEntity.ok(geocodeService.geocodeAddress(geocodeRequestDTO.getAddress()));
    }
}
