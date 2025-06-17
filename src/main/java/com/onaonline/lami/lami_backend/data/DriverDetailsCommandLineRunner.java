package com.onaonline.lami.lami_backend.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DriverDetailsCommandLineRunner implements CommandLineRunner {

    private DriverRepository driverRepository;

    public DriverDetailsCommandLineRunner(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        driverRepository.save()

    }
}
