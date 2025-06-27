package com.onaonline.lami.lami_backend.home;

import com.onaonline.lami.lami_backend.data.details.UserDetails;

import com.onaonline.lami.lami_backend.data.repos.UserRepository;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

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
    public SignUpDTO signup(SignUpDTO signuprequest){
//    var eliminates middle man step of having to make a object of a class to pass into database - springboot
        try{
            var user = UserDetails.builder().
                    username(signuprequest.getUsername())
                    .email(signuprequest.getEmail())
                    .phone_number(signuprequest.getPhone_number())
                    .password(signuprequest.getPassword()).latitude(signuprequest.getLatitude())
                            .longitude(signuprequest.getLongitude()).placeName(signuprequest.getPlaceName()).build();

            userRepository.save(user);
        }
        catch (Exception e){
            System.out.println(signuprequest.toString());
        }
        return signuprequest;

    }


    public boolean login(String email, String password) {

        Optional<UserDetails> optionalemail = userRepository.findByEmail(email);

        if(optionalemail.isPresent()){
            UserDetails user = optionalemail.get();
            return password.equals(user.getPassword());
        }
        return true;

    }

    public UserDetails profileview(String email){
//        should return users info if login returned true
        UserDetails user = userRepository.findByEmail(email).get();
        return user.builder().username(user.getUsername()).email(user.getEmail())
                .phone_number(user.getPhone_number()).build();

    }

//    Notes is it works but something is off. It is supposed to block emails that don't exist...instead status code is 200

    public String update(String email, String tochange, @NotBlank String value) {
        Optional<UserDetails> optionalUserDetails = userRepository.findByEmail(email);

        if(optionalUserDetails.isPresent()){
            UserDetails userDetails = optionalUserDetails.get();
            var user = userDetails.builder().username(userDetails.getUsername())
                    .email(userDetails.getEmail()).phone_number(userDetails.getPhone_number())
                    .password(userDetails.getPassword());

            switch (tochange){
                case "username" -> user.username(value);
                case "email" -> user.email(value);
                case "phone_number" -> user.phone_number(value);
//                Will realistically need way more authentication than this
                case "password" -> user.password(value);
            }

            userRepository.deleteById(userDetails.getId());
            userRepository.save(user.build());
        }

        return tochange;

    }

    public Long deleteById(String email) {

        Optional<UserDetails> user = userRepository.findByEmail(email);
        user.ifPresent(userDetails -> userRepository.deleteById(userDetails.getId()));
        return user.get().getId();

    }


}
