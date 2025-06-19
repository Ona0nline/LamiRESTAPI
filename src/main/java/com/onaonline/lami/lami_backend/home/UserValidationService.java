package com.onaonline.lami.lami_backend.home;

import com.onaonline.lami.lami_backend.data.UserDetails;

import com.onaonline.lami.lami_backend.data.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class UserValidationService {
    private final UserRepository userRepository;


    public Map<Object, Object> homeexample(){
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
    public UserValidation signup(UserValidation validrequest){
//    var eliminates middle man step of having to make a object of a class to pass into database - springboot
        var user = UserDetails.builder().
                username(validrequest.getUsername())
                .email(validrequest.getEmail())
                .phone_number(validrequest.getPhone_number())
                .password(validrequest.getPassword()).build();

        userRepository.save(user);

        return validrequest;
    }



}
