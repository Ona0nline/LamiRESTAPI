package com.onaonline.lami.lami_backend.rideoptions.taxi;

import com.onaonline.lami.lami_backend.externalApis.distancematrix.DistanceMatrixRequestDTO;
import com.onaonline.lami.lami_backend.externalApis.distancematrix.DistanceMatrixResponseDTO;
import com.onaonline.lami.lami_backend.externalApis.distancematrix.DistanceMatrixService;
import com.onaonline.lami.lami_backend.rideoptions.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//Current Location -> Ranks 20min away
//
@RestController
public class TaxiResource extends Ride {

    @Autowired
    private DistanceMatrixService distanceMatrixService;

    @PostMapping("/taxi/ranks")
    public ResponseEntity<?> nearbyRanks(@RequestBody DistanceMatrixRequestDTO distanceMatrixRequestDTO) throws Exception {
//        Purpose of this is only to find
        DistanceMatrixResponseDTO distanceMatrixResponseDTO = distanceMatrixService.distanceCalculator(distanceMatrixRequestDTO.getStartLocation(), distanceMatrixRequestDTO.getEndLocation());
        return ResponseEntity.ok("under construction");

    }

    @GetMapping("/taxi")
    public Map<String, Object> taxi() {
        return Map.of(
                "header", "Taxi",
                "pointA", "userlocation",
                "nearest_ranks",Map.of("" +
                        "name", "Name of rank",
                        "location", "Google maps location link",
                        "routes", "Routes")
        );
    }

    @GetMapping("/taxi/routes")
    public Map<String, Object> routes() {
        return Map.of("name", "Name of rank",
                "location", "Location of rank",
                "routes", Map.of("Route1", "Route1",
                                        "price", "R40"));
    }

    @GetMapping("/taxi/routes/{routeid}")
    public Map<String, Object> getRouteById(@PathVariable String routeid) {
//        Taxi Service...
        return Map.of("name", "Name of rank",
                "location", "Location of rank",
                "routeid", "showcase taxi route somehow");
    }
}
