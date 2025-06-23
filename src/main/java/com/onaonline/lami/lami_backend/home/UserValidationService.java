package com.onaonline.lami.lami_backend.home;

import com.onaonline.lami.lami_backend.data.UserDetails;

import com.onaonline.lami.lami_backend.data.repos.UserRepository;
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
                    .password(signuprequest.getPassword()).
                    location(signuprequest.getLocation()).build();

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
        System.out.println(userRepository.findByEmail(email).toString());
        UserDetails user = userRepository.findByEmail(email).get();
        var usernopassword = user.builder().username(user.getUsername()).email(user.getEmail())
                .phone_number(user.getPhone_number()).build();
       return usernopassword;

    }
}
