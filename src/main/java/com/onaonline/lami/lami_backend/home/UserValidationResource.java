package com.onaonline.lami.lami_backend.home;

//import com.onaonline.lami.lami_backend.data.details.UserDetails;
import com.onaonline.lami.lami_backend.data.details.UserDetails;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    @PostMapping("/profile")
//    ? placeholder for any object
    public ResponseEntity<?> profile(@Valid @RequestBody LoginDTO loginDTO) {
        boolean loginState = homeService.login(loginDTO.getEmail(), loginDTO.getPassword());
        if (loginState) {
            UserDetails user = homeService.profileview(loginDTO.getEmail());
            return ResponseEntity.ok(user);

        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed or user not found.");

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
