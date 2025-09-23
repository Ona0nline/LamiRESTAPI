package com.onaonline.lami.lami_backend.authentication;

import com.onaonline.lami.lami_backend.database.details.UserDetails;

import com.onaonline.lami.lami_backend.database.repos.UserRepository;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserValidationService {
    private final UserRepository userRepository;

    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$");
    }


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

//    I think after loggin in, return the user details
    public boolean login(String email, String password) {

        Optional<UserDetails> optionalemail = userRepository.findByEmail(email);

        if(optionalemail.isPresent()){
            UserDetails user = optionalemail.get();
            return password.equals(user.getPassword());
        }
        return true;

    }

    public UserDetails profileview(String email){

        UserDetails user = userRepository.findByEmail(email).get();
        return user.builder().username(user.getUsername()).email(user.getEmail())
                .phone_number(user.getPhone_number()).build();

    }

//    Notes is it works but something is off. It is supposed to block emails that don't exist...instead status code is 200

    public String update(String tochange, String email, String value) {
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
