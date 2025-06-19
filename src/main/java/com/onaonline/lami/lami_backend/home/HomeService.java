package com.onaonline.lami.lami_backend.home;

import com.onaonline.lami.lami_backend.data.UserDetails;

import com.onaonline.lami.lami_backend.data.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HomeService {
    private final UserRepository userRepository;


    public Home signup(Home validrequest){
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
