package com.onaonline.lami.lami_backend.home;

//import com.onaonline.lami.lami_backend.data.UserDetails;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserValidationResource {

    private UserValidationService homeService;

    @Autowired
    public UserValidationResource(UserValidationService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/")
    public Map<Object, Object> homePageHero(){
        return homeService.homeexample();

    }

    @PostMapping("/signup")
    public ResponseEntity<UserValidation> signup(@Valid @RequestBody UserValidation validhome){
        return ResponseEntity.ok(homeService.signup(validhome));


    }


}
