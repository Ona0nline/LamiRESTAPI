package com.onaonline.lami.lami_backend.data.runners;

import com.onaonline.lami.lami_backend.data.LamiDriverDetails;
import com.onaonline.lami.lami_backend.data.LamiLuxDriverDetails;
import com.onaonline.lami.lami_backend.data.repos.LamiLuxDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class LamiLuxDriverDetailsCommandLineRunner implements CommandLineRunner {

    private static List<LamiLuxDriverDetails> lamiLuxDriverDetails = new ArrayList<>();
    private static List<LamiLuxDriverDetails> lamiluxdriverList = new ArrayList<>();
    @Autowired
    private LamiLuxDriverRepository lamiLuxDriverRepository;


    @Override
    public void run(String... args) throws Exception {
        List<String> names = List.of("Themba Zwane", "Lerato Mokoena", "Kagiso Molefe", "Zanele Dlamini", "Thabo Nkosi", "Ayanda Mbatha", "Sipho Ndlovu", "Nandi Khumalo", "Mpho Sithole", "Tebogo Mashaba", "Nomvula Hadebe", "Tshepo Maluleka", "Precious Moeketsi", "Dumisani Sithole", "Boitumelo Mhlongo", "Andile Mokoena", "Sihle Dube", "Naledi Zondo", "Sibusiso Mtshali", "Karabo Mahlangu");

        List<String> cars = List.of("Audi R8", "Mercedes-Benz S-Class", "BMW 7 Series", "Range Rover Autobiography", "Tesla Model X", "Porsche Panamera", "Lexus LS 500", "Jaguar XJ", "Maserati Quattroporte", "Bentley Continental GT");

        List<String> rideStatuses = List.of("Advanced Defensive Driving", "Luxury Chauffeur Accreditation", "VIP Handling", "GT Class Mastery");

        List<String> driverLevels = List.of("Elite Chauffeur Level 3", "Diamond Tier", "Certified Luxe", "Platinum Driver");

        List<List<String>> perksList = List.of(
                List.of("Champagne on arrival", "Driver waits for you", "Heated seats"),
                List.of("Slippers provided", "Unlimited stops", "Quiet mode option"),
                List.of("Spotify Premium", "Ambient lights", "Snacks"),
                List.of("Silk slippers", "Chauffeur umbrella", "Pre-cooled cabin")
        );



        for (int i = 0; i < 20; i++) {
            String name = names.get(i);
            String car = cars.get(i % cars.size());
            String rideStatus = rideStatuses.get(i % rideStatuses.size());
            String driverLevel = driverLevels.get(i % driverLevels.size());
            List<String> perks = perksList.get(i % perksList.size());

            LamiLuxDriverDetails driver = LamiLuxDriverDetails.builder()
                    .drivername(name)
                    .driveridnumber("9903" + i + "5123489")
                    .phonenumber("073 867 34" + String.format("%02d", i))
                    .email(name.toLowerCase().replaceAll(" ", ".") + "@lamidrivers.com")
                    .is_availiable(true)
                    .car(car)
                    .license_plate("GP " + (10 + i) + " XX GP")
                    .location("Johannesburg")
                    .ride_status(rideStatus)
                    .perks(perks)
                    .driverlevel(driverLevel)
                    .build();

            lamiluxdriverList.add(driver);
        }

        lamiLuxDriverRepository.saveAll(lamiluxdriverList);


    }
}
