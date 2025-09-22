package com.onaonline.lami.lami_backend.authentication;

import com.onaonline.lami.lami_backend.database.details.UserDetails;
import com.onaonline.lami.lami_backend.rideoptions.lami.LamiService;
import com.onaonline.lami.lami_backend.rideoptions.lux.LuxuryService;
import com.onaonline.lami.lami_backend.util.JWT;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserValidationResource {

    @Autowired
    HttpSession session;

    @Autowired
    private UserValidationService homeService;

    @Autowired
    private LamiService lamiService;

    @Autowired
    private LuxuryService luxuryService;

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
            String token = JWT.generateToken(loginDTO.getEmail());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Unauthorized login");

    }


    @GetMapping("/profile")
    public ResponseEntity<?> profile(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Missing token");
        }

        String token = authHeader.substring(7); // remove "Bearer "
        String email = JWT.validateTokenAndGetEmail(token);
        System.out.println("User email according to token: " + email);
        if(email != null){
            UserDetails user = homeService.profileview(email);
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email");


    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@Valid @RequestBody UpdateDTO updateDTO){
        boolean loginState = homeService.login(updateDTO.getEmail(), updateDTO.getPassword());
        if (loginState) {
            String tochange = homeService.update(updateDTO.getEmail(),updateDTO.getTochange(), updateDTO.getValue());
            return ResponseEntity.ok("Successfully changed the " + tochange );

        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed or user not found.");

    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LoginDTO logintodeleteDTO){

        boolean loginState = homeService.login(logintodeleteDTO.getEmail(), logintodeleteDTO.getPassword());
        if (loginState) {
            Long userid = homeService.deleteById(logintodeleteDTO.getEmail());
            return ResponseEntity.ok(userid);

        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed or user not found.");

    }





}
