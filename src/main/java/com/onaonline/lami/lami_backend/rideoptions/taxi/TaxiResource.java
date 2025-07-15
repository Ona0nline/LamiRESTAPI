package com.onaonline.lami.lami_backend.rideoptions.taxi;

import com.onaonline.lami.lami_backend.externalApis.distancematrix.DistanceMatrixRequestDTO;
import com.onaonline.lami.lami_backend.externalApis.distancematrix.DistanceMatrixResponseDTO;
import com.onaonline.lami.lami_backend.externalApis.distancematrix.DistanceMatrixService;
import com.onaonline.lami.lami_backend.externalApis.geocoding.GeocodeRequestDTO;
import com.onaonline.lami.lami_backend.externalApis.geocoding.GeocodeResponseDTO;
import com.onaonline.lami.lami_backend.externalApis.geocoding.GeocodeService;
import com.onaonline.lami.lami_backend.rideoptions.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//Current Location -> Ranks 20min away
//
@RestController
public class TaxiResource extends Ride {

    @Autowired
    private GeocodeService geocodeService;

    @Autowired
    private TaxiService taxiService;

    @PostMapping("/taxi/ranks")
    public ResponseEntity<?> nearbyRanks(@RequestBody GeocodeRequestDTO geocodeRequestDTO) throws Exception {
//        Purpose of this is only to find
        GeocodeResponseDTO geocodeResponseDTO = geocodeService.geocodeAddress(geocodeRequestDTO.address);
        List<Map<String, Object>> nearbyTaxiRanks = taxiService.nearbyRanks(geocodeResponseDTO.getLatitude(), geocodeResponseDTO.getLongitude());
        return ResponseEntity.ok(nearbyTaxiRanks);

    }

}
