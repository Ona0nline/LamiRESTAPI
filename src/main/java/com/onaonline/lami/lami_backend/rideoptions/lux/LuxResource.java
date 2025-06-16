package com.onaonline.lami.lami_backend.rideoptions.lux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LuxResource {

    @GetMapping("/luxury")
    public Map<String, String> luxury() {
        return Map.of(
                "header", "Luxury",
                "pointA", "userlocation",
                "pointB","destinationlocation",
                "drivername", "Themba Driver",
                "car", "Rolls Royce",
                "license-plate", "KJ 11 ND GP",
                "certs", "What makes the driver special",
                "more", "More lux stuff",
                "price", "R40"
        );
    }
}
