package com.onaonline.lami.lami_backend.rideoptions.lami;

import com.onaonline.lami.lami_backend.database.details.RideDetailsLami;
import com.onaonline.lami.lami_backend.externalApis.distancematrix.DistanceMatrixRequestDTO;
import com.onaonline.lami.lami_backend.externalApis.distancematrix.DistanceMatrixResponseDTO;
import com.onaonline.lami.lami_backend.externalApis.distancematrix.DistanceMatrixService;
import com.onaonline.lami.lami_backend.externalApis.geocoding.GeocodeResponseDTO;
import com.onaonline.lami.lami_backend.externalApis.geocoding.GeocodeService;
import com.onaonline.lami.lami_backend.rideoptions.Ride;
import jakarta.servlet.http.HttpSession;
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

    @Autowired
    HttpSession session;


//    session attribute stuff should move here too

    @PostMapping("/lami/available-rides")
    public ResponseEntity<Object> availablerides(@RequestBody DistanceMatrixRequestDTO distanceMatrixRequestDTO) throws Exception {

//        Users start and end locations in a session
        session.setAttribute("startLocation", distanceMatrixRequestDTO.getStartLocation());
        session.setAttribute("endLocation", distanceMatrixRequestDTO.getEndLocation());

        DistanceMatrixResponseDTO distanceMatrixResponse = distanceMatrixService.distanceCalculatorLami(distanceMatrixRequestDTO.getStartLocation(),distanceMatrixRequestDTO.getEndLocation());
        session.setAttribute("fare", distanceMatrixResponse.getFare());
        GeocodeResponseDTO geocodeResponseDTO = geocodeService.geocodeAddress(distanceMatrixRequestDTO.getStartLocation());
        System.out.println(distanceMatrixResponse);
        List<Map<String, Object>> results = lamiService.displayavailablerides(geocodeResponseDTO.getLatitude(),geocodeResponseDTO.getLongitude());

        AvailableRidesResponseDTO availableRidesResponse = new AvailableRidesResponseDTO(distanceMatrixResponse,results, distanceMatrixRequestDTO.getStartLocation(), distanceMatrixRequestDTO.getEndLocation());
        if (results.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(availableRidesResponse);
    }


    @PostMapping("/lami/request-ride")
    public ResponseEntity<RideDetailsLami> requestride(@RequestBody UserLocationDTO userLocationDTO) {
//        Session attributes
        String userStart = (String) session.getAttribute("startLocation");
        String userEnd = (String) session.getAttribute("endLocation");
        String rideFare = (String) session.getAttribute("fare");
        String email = (String) session.getAttribute("email");

        RideDetailsLami rideDetailsLami = lamiService.bookride(userLocationDTO.getDriverId(), userStart,userEnd,rideFare, email);
        session.setAttribute("requestedRide", rideDetailsLami);
        return ResponseEntity.ok(rideDetailsLami);
    }

    @DeleteMapping("/lami/cancel-ride")
    public ResponseEntity<?> cancelride(@RequestBody CancelRideRequestDTO cancelRideRequestDTO){
//        Should remove the ride from the session and from the database
        return ResponseEntity.ok(lamiService.cancelRide(cancelRideRequestDTO.getRideId()));
    }

    @PutMapping("/lami/edit-ride")
    public ResponseEntity<?> editRide(@RequestBody EditRideDTO editRideDTO) {
        RideDetailsLami requestedRide = (RideDetailsLami) session.getAttribute("requestedRide");
        return ResponseEntity.ok(lamiService.editRide(editRideDTO.getNewStartLocation(), editRideDTO.getNewEndLocation(), requestedRide));
    }

    @GetMapping("/lami/ride-history")
    public ResponseEntity<?> getRideHistory(HttpSession session){
        String email = (String) session.getAttribute("email");
        List<RideDetailsLami> rides = lamiService.rideHistory(email);

        if(rides.isEmpty()){
            return ResponseEntity.ok("Ride history empty");
        }
        return ResponseEntity.ok(rides);
    }
//    Is a service method neccessary since we're storing sessions? Should I send the entire session over to the service?



}
