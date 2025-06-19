package com.onaonline.lami.lami_backend.home;

//import com.onaonline.lami.lami_backend.data.UserDetails;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class HomeResource {

    private HomeService homeService;

    @Autowired
    public HomeResource(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/")
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

    @PostMapping("/signup")
    public ResponseEntity<Home> signup(@Valid @RequestBody Home validhome){
        return ResponseEntity.ok(homeService.signup(validhome));


    }


}
