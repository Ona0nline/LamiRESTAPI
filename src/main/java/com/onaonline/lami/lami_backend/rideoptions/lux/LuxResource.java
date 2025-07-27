package com.onaonline.lami.lami_backend.rideoptions.lux;

import com.onaonline.lami.lami_backend.database.details.RideDetailsLami;
import com.onaonline.lami.lami_backend.database.details.RideDetailsLux;
import com.onaonline.lami.lami_backend.externalApis.distancematrix.DistanceMatrixLuxResponseDTO;
import com.onaonline.lami.lami_backend.externalApis.distancematrix.DistanceMatrixRequestDTO;
import com.onaonline.lami.lami_backend.externalApis.distancematrix.DistanceMatrixService;
import com.onaonline.lami.lami_backend.externalApis.geocoding.GeocodeResponseDTO;
import com.onaonline.lami.lami_backend.externalApis.geocoding.GeocodeService;
import com.onaonline.lami.lami_backend.rideoptions.lami.AvailableRidesResponseDTO;
import com.onaonline.lami.lami_backend.rideoptions.lami.CancelRideRequestDTO;
import com.onaonline.lami.lami_backend.rideoptions.lami.EditRideDTO;
import com.onaonline.lami.lami_backend.rideoptions.lami.UserLocationDTO;
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
public class LuxResource extends Ride {

    @Autowired
    private GeocodeService geocodeService;

    @Autowired
    private LuxuryService luxuryService;

    @Autowired
    private DistanceMatrixService distanceMatrixService;

    @Autowired
    HttpSession session;

    @PostMapping("/lamilux/available-rides")
    public ResponseEntity<?> availabledrivers(@RequestBody DistanceMatrixRequestDTO distanceMatrixRequestDTO) throws Exception {

        session.setAttribute("startLocation", distanceMatrixRequestDTO.getStartLocation());
        session.setAttribute("endLocation", distanceMatrixRequestDTO.getEndLocation());

//        Literally just distance and duration
        DistanceMatrixLuxResponseDTO distanceMatrixResponseLux = distanceMatrixService.distanceCalculatorLux(distanceMatrixRequestDTO.getStartLocation(),distanceMatrixRequestDTO.getEndLocation());
        System.out.println(distanceMatrixResponseLux);
//        NB: THIS FARE == ride-sharing fair, not car/service fare
        session.setAttribute("fare", distanceMatrixResponseLux.getFare());
        GeocodeResponseDTO geocodeResponseDTO = geocodeService.geocodeAddress(distanceMatrixRequestDTO.getStartLocation());

        List<Map<String, Object>> results = luxuryService.displayavailablerides(geocodeResponseDTO.getLatitude(),geocodeResponseDTO.getLongitude());
        AvailableRidesLuxResponseDTO availableRidesResponse = new AvailableRidesLuxResponseDTO(distanceMatrixResponseLux,results, distanceMatrixRequestDTO.getStartLocation(), distanceMatrixRequestDTO.getEndLocation());
        if (results.isEmpty()) return ResponseEntity.ok("List empty");
        return ResponseEntity.ok(availableRidesResponse);
    }


    @PostMapping("lamilux/request-ride")
    public ResponseEntity<?> requestRide(@RequestBody UserLocationDTO userLocationDTO){

        String userStart = (String) session.getAttribute("startLocation");
        String userEnd = (String) session.getAttribute("endLocation");
        double rideFare = (double) session.getAttribute("fare");
        String email = (String) session.getAttribute("email");

        RideDetailsLux rideDetailsLux = luxuryService.bookride(userLocationDTO.getDriverId(),userStart,userEnd,rideFare, email);
        session.setAttribute("requestedRide", rideDetailsLux);

        return ResponseEntity.ok(rideDetailsLux);
    }

    @DeleteMapping("/lamilux/cancel-ride")
    public ResponseEntity<?> cancelride(@RequestBody CancelRideRequestDTO cancelRideRequestDTO){
//        Should remove the ride from the session and from the database
        return ResponseEntity.ok(luxuryService.cancelRide(cancelRideRequestDTO.getRideId()));
    }

    @PutMapping("/lamilux/edit-ride")
    public ResponseEntity<?> editRide(@RequestBody EditRideDTO editRideDTO) {
        RideDetailsLux requestedRide = (RideDetailsLux) session.getAttribute("requestedRide");
        return ResponseEntity.ok(luxuryService.editRide(editRideDTO.getNewStartLocation(), editRideDTO.getNewEndLocation(), requestedRide));
    }

    @GetMapping("/lamilux/ride-history")
    public ResponseEntity<?> getRideHistory(HttpSession session){
        String email = (String) session.getAttribute("email");
        List<RideDetailsLux> rides = luxuryService.rideHistory(email);

        if(rides.isEmpty()){
            return ResponseEntity.ok("Ride history empty");
        }
        return ResponseEntity.ok(rides);
    }
}
