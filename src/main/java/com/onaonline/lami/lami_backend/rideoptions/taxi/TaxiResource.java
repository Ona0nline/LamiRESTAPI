package com.onaonline.lami.lami_backend.rideoptions.taxi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TaxiResource {

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
