package com.onaonline.lami.lami_backend.rideoptions.taxi;

import com.onaonline.lami.lami_backend.database.details.RoutesDetails;
import com.onaonline.lami.lami_backend.externalApis.geocoding.GeocodeRequestDTO;
import com.onaonline.lami.lami_backend.externalApis.geocoding.GeocodeResponseDTO;
import com.onaonline.lami.lami_backend.externalApis.geocoding.GeocodeService;
import com.onaonline.lami.lami_backend.rideoptions.Ride;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Current Location -> Ranks 20min away
//
@RestController
public class TaxiResource extends Ride {

    @Autowired
    HttpSession session;

    @Autowired
    private GeocodeService geocodeService;

    @Autowired
    private TaxiService taxiService;

//
    @PostMapping("/taxi/ranks")
    public ResponseEntity<?> nearbyRanks(@RequestBody GeocodeRequestDTO geocodeRequestDTO) throws Exception {
//        Purpose of this is only to find
        GeocodeResponseDTO geocodeResponseDTO = geocodeService.geocodeAddress(geocodeRequestDTO.address);
        List<Map<String, Object>> nearbyTaxiRanks = taxiService.nearbyRanks(geocodeResponseDTO.getLatitude(), geocodeResponseDTO.getLongitude());
        session.setAttribute("nearbyRanks", nearbyTaxiRanks);
        return ResponseEntity.ok(nearbyTaxiRanks);

    }

    @PostMapping("/taxi/ranks/routes")
    public ResponseEntity<?> specificRoute(@RequestBody RouteRequestDTO routeRequestDTO){
        List<Map<String, Object>> nearbyRanks = (List<Map<String, Object>>) session.getAttribute("nearbyRanks");
        System.out.println(nearbyRanks);
        if (nearbyRanks == null) {
            return ResponseEntity.badRequest().body("No cached ranks found in session. Please search again.");
        }

        List<Map<String, Object>> routesDetails = new ArrayList<>();

        for(Map<String, Object> rank : nearbyRanks){
            System.out.println(rank);

            if(routeRequestDTO.getRankId().equals(Long.valueOf(rank.get("id").toString()))){
                routesDetails = taxiService.routeByRankid(routeRequestDTO.getRankId());
            }
        }
        return ResponseEntity.ok(routesDetails);
    }

}
