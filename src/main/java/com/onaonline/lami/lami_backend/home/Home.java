package com.onaonline.lami.lami_backend.home;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Home {

    @GetMapping("/home")
    public Map<Object, Object> homePageHero(){
        return Map.of(
                "title", "Welcome to Lami",
                "subheading", "A ridesharing app for all tiers of users",
                "rides", Map.of("" +
                        "lami", "Lami",
                        "taxi", "Taxi",
                        "lux", "Luxury"),
                "footer", "click here to find out more about them"
        );
    }
}
