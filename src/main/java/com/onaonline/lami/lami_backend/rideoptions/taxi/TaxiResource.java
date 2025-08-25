package com.onaonline.lami.lami_backend.rideoptions.taxi;

import com.onaonline.lami.lami_backend.database.details.TaxiRanks;
import com.onaonline.lami.lami_backend.externalApis.geocoding.GeocodeRequestDTO;
import com.onaonline.lami.lami_backend.externalApis.geocoding.GeocodeResponseDTO;
import com.onaonline.lami.lami_backend.externalApis.geocoding.GeocodeService;
import com.onaonline.lami.lami_backend.externalApis.osrm.OsrmPopulationDTO;
import com.onaonline.lami.lami_backend.externalApis.osrm.OSRMService;
import com.onaonline.lami.lami_backend.externalApis.roads.RoadsRequestDTO;
import com.onaonline.lami.lami_backend.externalApis.roads.RoadsService;
import com.onaonline.lami.lami_backend.rideoptions.LocationDTO;
import com.onaonline.lami.lami_backend.rideoptions.Ride;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
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
    @Autowired
    private RoadsService roadsService;

    @Autowired
    private OSRMService osrmService;

    //
    @PostMapping("/taxi/ranks")
    public ResponseEntity<?> nearbyRanks(@RequestBody GeocodeRequestDTO geocodeRequestDTO) throws Exception {
//        Purpose of this is only to find
        GeocodeResponseDTO geocodeResponseDTO = geocodeService.geocodeAddress(geocodeRequestDTO.address);
        List<Map<String, Object>> nearbyTaxiRanks = taxiService.nearbyRanks(geocodeResponseDTO.getLatitude(), geocodeResponseDTO.getLongitude());
        session.setAttribute("nearbyRanks", nearbyTaxiRanks);
        session.setAttribute("longitude", geocodeResponseDTO.getLongitude());
        session.setAttribute("latitude", geocodeResponseDTO.getLatitude());

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

    @PostMapping("taxi/ranks/routepath")
    public ResponseEntity<?> specificRoute(@RequestBody RoadsRequestDTO roadsRequestDTO) throws Exception {
        GeocodeResponseDTO startLocationGeocoded = geocodeService.geocodeAddress(roadsRequestDTO.getStartLocation());
        GeocodeResponseDTO endLocationGeocoded = geocodeService.geocodeAddress(roadsRequestDTO.getEndLocation());

        List<HashMap<String, Double>> path = roadsService.routePathCoords(startLocationGeocoded.getLatitude(), startLocationGeocoded.getLongitude(), endLocationGeocoded.getLatitude(), endLocationGeocoded.getLongitude());
        return ResponseEntity.ok(path);

    }

//    This was just to populate the database with snapped taxi rank routes
    @PostMapping("taxi/population")
    public ResponseEntity<?> osrmTest(@RequestBody OsrmPopulationDTO osrmtestdto) throws Exception {
        return ResponseEntity.ok(osrmService.getOsrmMetaData(osrmtestdto.getStart(), osrmtestdto.getEnd()));

    }

//    taxi ranks that have routes that have my location within them.
    @PostMapping("taxi/rankByCoverage")
    public ResponseEntity<?> ranksByRouteCoverage(@RequestBody LocationDTO locationDTO) throws Exception {
        GeocodeResponseDTO geocodeResponseDTO = geocodeService.geocodeAddress(locationDTO.getAddress());

        session.setAttribute("longitude", geocodeResponseDTO.getLongitude());
        session.setAttribute("latitude", geocodeResponseDTO.getLatitude());

        return ResponseEntity.ok(taxiService.ranksByRouteCoverage(geocodeResponseDTO.getLongitude(), geocodeResponseDTO.getLatitude()));

    }

//    routes in the database that have my location within them
//    @PostMapping("taxi/population")
//    public ResponseEntity<?> osrmTest(@RequestBody OSRMDTO osrmtestdto) throws Exception {
//        return ResponseEntity.ok(osrmService.getOsrmMetaData(osrmtestdto.getStart(), osrmtestdto.getEnd()));
//
//    }

}
