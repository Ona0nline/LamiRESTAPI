package com.onaonline.lami.lami_backend.database.runners;

import com.onaonline.lami.lami_backend.database.repos.RouteRepository;
import com.onaonline.lami.lami_backend.rideoptions.taxi.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RouteCoordinateCLR implements CommandLineRunner {
    @Autowired
    private TaxiService taxiService;

    @Override
    public void run(String... args) throws Exception {
//        Have a loop for however many routes I wish to save, then save all that data in there


    }
}
