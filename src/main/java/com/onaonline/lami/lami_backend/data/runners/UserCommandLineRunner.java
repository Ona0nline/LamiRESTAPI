package com.onaonline.lami.lami_backend.data.runners;

import com.onaonline.lami.lami_backend.data.UserDetails;
import com.onaonline.lami.lami_backend.data.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserCommandLineRunner implements Runnable {

    private static List<UserDetails> userDetails = new ArrayList<>();
    private UserRepository userRepository;

    static {
        userDetails.add(new UserDetails());
    }

    @Autowired
    public UserCommandLineRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void run() {


    }
}
