package com.onaonline.lami.lami_backend.home;

//import com.onaonline.lami.lami_backend.data.UserDetails;
import com.onaonline.lami.lami_backend.data.UserDetails;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

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
    public ResponseEntity<SignUpDTO> signup(@Valid @RequestBody SignUpDTO signUpDTO){
        return ResponseEntity.ok(homeService.signup(signUpDTO));

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDTO loginDTO){
//    Response entity returns http responses (status, headers and body)
        if(homeService.login(loginDTO.getEmail(), loginDTO.getPassword())){
            return ResponseEntity.ok("Login Successful");
        }
        return ResponseEntity.status(401).body("Unauthorized login");

    }


}
