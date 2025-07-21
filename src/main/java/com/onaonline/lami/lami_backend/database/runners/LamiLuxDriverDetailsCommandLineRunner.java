package com.onaonline.lami.lami_backend.database.runners;

import com.onaonline.lami.lami_backend.database.details.LamiLuxDriverDetails;
import com.onaonline.lami.lami_backend.database.repos.LamiLuxDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class LamiLuxDriverDetailsCommandLineRunner implements CommandLineRunner {

    @Autowired
    private LamiLuxDriverRepository lamiLuxDriverRepository;

    @Override
    public void run(String... args) throws Exception {
        List<LamiLuxDriverDetails> lamiLuxDriverDetails = new ArrayList<>();

        lamiLuxDriverDetails.add(new LamiLuxDriverDetails("Themba Zwane", "9903145123489", "073 867 3401", "themba.zwane@lamidrivers.com", true, "Audi R8", "GP 21 XX GP", "Advanced Defensive Driving", Arrays.asList("Champagne on arrival", "Driver waits for you", "Heated seats"), "Elite Chauffeur Level 3", -26.2041, 28.0473, "Sandton, Johannesburg"));
        lamiLuxDriverDetails.add(new LamiLuxDriverDetails("Lerato Mokoena", "8905123789321", "073 867 3402", "lerato.mokoena@lamidrivers.com", true, "Mercedes-Benz S-Class", "GP 22 XX GP", "Luxury Chauffeur Accreditation", Arrays.asList("Slippers provided", "Unlimited stops", "Quiet mode option"), "Diamond Tier", -25.7461, 28.1881, "Pretoria CBD"));
        lamiLuxDriverDetails.add(new LamiLuxDriverDetails("Kagiso Molefe", "9007264512398", "073 867 3403", "kagiso.molefe@lamidrivers.com", false, "BMW 7 Series", "GP 23 XX GP", "VIP Handling", Arrays.asList("Spotify Premium", "Ambient lights", "Snacks"), "Certified Luxe", -29.8587, 31.0218, "Durban North"));
        lamiLuxDriverDetails.add(new LamiLuxDriverDetails("Zanele Dlamini", "9211062398123", "073 867 3404", "zanele.dlamini@lamidrivers.com", false, "Range Rover Autobiography", "GP 24 XX GP", "GT Class Mastery", Arrays.asList("Silk slippers", "Chauffeur umbrella", "Pre-cooled cabin"), "Platinum Driver", -33.9249, 18.4241, "Cape Town CBD"));
        lamiLuxDriverDetails.add(new LamiLuxDriverDetails("Thabo Nkosi", "8602045123981", "073 867 3405", "thabo.nkosi@lamidrivers.com", true, "Tesla Model X", "GP 25 XX GP", "Advanced Defensive Driving", Arrays.asList("Champagne on arrival", "Driver waits for you", "Heated seats"), "Elite Chauffeur Level 3", -25.9804, 28.0139, "Centurion Mall"));
        lamiLuxDriverDetails.add(new LamiLuxDriverDetails("Ayanda Mbatha", "9301185123490", "073 867 3406", "ayanda.mbatha@lamidrivers.com", true, "Porsche Panamera", "GP 26 XX GP", "Luxury Chauffeur Accreditation", Arrays.asList("Slippers provided", "Unlimited stops", "Quiet mode option"), "Diamond Tier", -26.2708, 28.1123, "Eastgate Mall, Bedfordview"));
        lamiLuxDriverDetails.add(new LamiLuxDriverDetails("Sipho Ndlovu", "8905034598310", "073 867 3407", "sipho.ndlovu@lamidrivers.com", false, "Lexus LS 500", "GP 27 XX GP", "VIP Handling", Arrays.asList("Spotify Premium", "Ambient lights", "Snacks"), "Certified Luxe", -33.9180, 25.5701, "Port Elizabeth CBD"));
        lamiLuxDriverDetails.add(new LamiLuxDriverDetails("Nandi Khumalo", "9509078234901", "073 867 3408", "nandi.khumalo@lamidrivers.com", true, "Jaguar XJ", "GP 28 XX GP", "GT Class Mastery", Arrays.asList("Silk slippers", "Chauffeur umbrella", "Pre-cooled cabin"), "Platinum Driver", -26.5225, 31.4659, "Mbabane, Eswatini"));
        lamiLuxDriverDetails.add(new LamiLuxDriverDetails("Mpho Sithole", "9101245123409", "073 867 3409", "mpho.sithole@lamidrivers.com", true, "Maserati Quattroporte", "GP 29 XX GP", "Advanced Defensive Driving", Arrays.asList("Champagne on arrival", "Driver waits for you", "Heated seats"), "Elite Chauffeur Level 3", -24.6544, 25.9086, "Gaborone, Botswana"));
        lamiLuxDriverDetails.add(new LamiLuxDriverDetails("Tebogo Mashaba", "8803145123487", "073 867 3410", "tebogo.mashaba@lamidrivers.com", false, "Bentley Continental GT", "GP 30 XX GP", "Luxury Chauffeur Accreditation", Arrays.asList("Slippers provided", "Unlimited stops", "Quiet mode option"), "Diamond Tier", -29.1139, 26.2140, "Bloemfontein CBD"));
        lamiLuxDriverDetails.add(new LamiLuxDriverDetails("Nomvula Hadebe", "8704124512309", "073 867 3411", "nomvula.hadebe@lamidrivers.com", true, "Audi R8", "GP 31 XX GP", "VIP Handling", Arrays.asList("Spotify Premium", "Ambient lights", "Snacks"), "Certified Luxe", -33.0359, 27.8748, "East London Beachfront"));
        lamiLuxDriverDetails.add(new LamiLuxDriverDetails("Tshepo Maluleka", "9208025123476", "073 867 3412", "tshepo.maluleka@lamidrivers.com", true, "Mercedes-Benz S-Class", "GP 32 XX GP", "GT Class Mastery", Arrays.asList("Silk slippers", "Chauffeur umbrella", "Pre-cooled cabin"), "Platinum Driver", -26.1596, 27.8679, "Potchefstroom Central"));
        lamiLuxDriverDetails.add(new LamiLuxDriverDetails("Precious Moeketsi", "9005178234981", "073 867 3413", "precious.moeketsi@lamidrivers.com", true, "BMW 7 Series", "GP 33 XX GP", "Advanced Defensive Driving", Arrays.asList("Champagne on arrival", "Driver waits for you", "Heated seats"), "Elite Chauffeur Level 3", -30.5595, 22.9375, "Northern Cape Region"));
        lamiLuxDriverDetails.add(new LamiLuxDriverDetails("Dumisani Sithole", "8906234981023", "073 867 3414", "dumisani.sithole@lamidrivers.com", true, "Range Rover Autobiography", "GP 34 XX GP", "Luxury Chauffeur Accreditation", Arrays.asList("Slippers provided", "Unlimited stops", "Quiet mode option"), "Diamond Tier", -28.4793, 24.6727, "Kimberley Big Hole"));
        lamiLuxDriverDetails.add(new LamiLuxDriverDetails("Boitumelo Mhlongo", "9603124098231", "073 867 3415", "boitumelo.mhlongo@lamidrivers.com", false, "Tesla Model X", "GP 35 XX GP", "VIP Handling", Arrays.asList("Spotify Premium", "Ambient lights", "Snacks"), "Certified Luxe", -23.9043, 29.4486, "Polokwane Mall"));
        lamiLuxDriverDetails.add(new LamiLuxDriverDetails("Andile Mokoena", "8806095123408", "073 867 3416", "andile.mokoena@lamidrivers.com", true, "Porsche Panamera", "GP 36 XX GP", "GT Class Mastery", Arrays.asList("Silk slippers", "Chauffeur umbrella", "Pre-cooled cabin"), "Platinum Driver", -25.7482, 28.2293, "Menlyn, Pretoria"));
        lamiLuxDriverDetails.add(new LamiLuxDriverDetails("Sihle Dube", "9402105123789", "073 867 3417", "sihle.dube@lamidrivers.com", false, "Lexus LS 500", "GP 37 XX GP", "Advanced Defensive Driving", Arrays.asList("Champagne on arrival", "Driver waits for you", "Heated seats"), "Elite Chauffeur Level 3", -29.8587, 31.0218, "Moses Mabhida Stadium, Durban"));
        lamiLuxDriverDetails.add(new LamiLuxDriverDetails("Naledi Zondo", "9308185123490", "073 867 3418", "naledi.zondo@lamidrivers.com", true, "Jaguar XJ", "GP 38 XX GP", "Luxury Chauffeur Accreditation", Arrays.asList("Slippers provided", "Unlimited stops", "Quiet mode option"), "Diamond Tier", -26.2708, 28.1123, "Bedford Centre"));
        lamiLuxDriverDetails.add(new LamiLuxDriverDetails("Sibusiso Mtshali", "8505175123482", "073 867 3419", "sibusiso.mtshali@lamidrivers.com", true, "Maserati Quattroporte", "GP 39 XX GP", "VIP Handling", Arrays.asList("Spotify Premium", "Ambient lights", "Snacks"), "Certified Luxe", -26.2450, 27.8236, "Vanderbijlpark Riverside"));
        lamiLuxDriverDetails.add(new LamiLuxDriverDetails("Karabo Mahlangu", "9109205123456", "073 867 3420", "karabo.mahlangu@lamidrivers.com", false, "Bentley Continental GT", "GP 40 XX GP", "GT Class Mastery", Arrays.asList("Silk slippers", "Chauffeur umbrella", "Pre-cooled cabin"), "Platinum Driver", -26.0998, 28.2536, "Greenstone Mall"));

        lamiLuxDriverRepository.saveAll(lamiLuxDriverDetails);
    }
}
