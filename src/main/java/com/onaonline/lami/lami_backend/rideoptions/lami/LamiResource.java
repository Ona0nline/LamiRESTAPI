package com.onaonline.lami.lami_backend.rideoptions.lami;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LamiResource {

    @GetMapping("/lami")
    public Map<String, String> lami() {
        return Map.of(
                "header", "Lami",
                "pointA", "userlocation",
                "pointB","destinationlocation",
                "drivername", "Themba Driver",
                "car", "Toyota Corolla",
                "license-plate", "Cr 54 GG GP",
                "perks", "List of perks",
                "price", "R40"
        );
    }


}
