package com.onaonline.lami.lami_backend.database.runners;

import com.onaonline.lami.lami_backend.database.details.TaxiRanks;
import com.onaonline.lami.lami_backend.database.repos.TaxiRankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaxiRanksCLR implements CommandLineRunner {

    private static final List<TaxiRanks> TAXI_RANK_DETAILS = new ArrayList<>();

    @Autowired
    private TaxiRankRepository taxiRankRepository;

    static {
        // Gauteng
        TAXI_RANK_DETAILS.add(new TaxiRanks("MTN Taxi Rank", -26.2022, 28.0416, "Gauteng"));
        TAXI_RANK_DETAILS.add(new TaxiRanks("Bree Street Taxi Rank", -26.2041, 28.0341, "Gauteng"));
        TAXI_RANK_DETAILS.add(new TaxiRanks("Randburg Taxi Rank", -26.0945, 28.0077, "Gauteng"));

        // Western Cape
        TAXI_RANK_DETAILS.add(new TaxiRanks("Cape Town Station Deck", -33.9249, 18.4241, "Western Cape"));
        TAXI_RANK_DETAILS.add(new TaxiRanks("Bellville Taxi Rank", -33.9021, 18.6293, "Western Cape"));
        TAXI_RANK_DETAILS.add(new TaxiRanks("Mitchells Plain Town Centre", -34.0491, 18.6266, "Western Cape"));

        // KwaZulu-Natal
        TAXI_RANK_DETAILS.add(new TaxiRanks("Warwick Junction", -29.8535, 31.0099, "KwaZulu-Natal"));
        TAXI_RANK_DETAILS.add(new TaxiRanks("Bridge City Taxi Rank", -29.7014, 31.0397, "KwaZulu-Natal"));
        TAXI_RANK_DETAILS.add(new TaxiRanks("Pinetown CBD Rank", -29.8196, 30.8678, "KwaZulu-Natal"));

        // Eastern Cape
        TAXI_RANK_DETAILS.add(new TaxiRanks("North End Taxi Rank", -33.9275, 25.6023, "Eastern Cape"));
        TAXI_RANK_DETAILS.add(new TaxiRanks("Mdantsane Taxi Rank", -32.9272, 27.6966, "Eastern Cape"));
        TAXI_RANK_DETAILS.add(new TaxiRanks("Uitenhage Taxi Rank", -33.7681, 25.4016, "Eastern Cape"));

        // Free State
        TAXI_RANK_DETAILS.add(new TaxiRanks("Bloemfontein CBD Rank", -29.1184, 26.2297, "Free State"));
        TAXI_RANK_DETAILS.add(new TaxiRanks("Welkom Taxi Rank", -27.9833, 26.7333, "Free State"));
        TAXI_RANK_DETAILS.add(new TaxiRanks("Botshabelo Taxi Rank", -29.2301, 26.7186, "Free State"));

        // Limpopo
        TAXI_RANK_DETAILS.add(new TaxiRanks("Polokwane Taxi Rank", -23.9043, 29.4486, "Limpopo"));
        TAXI_RANK_DETAILS.add(new TaxiRanks("Thohoyandou Taxi Rank", -22.9747, 30.4527, "Limpopo"));
        TAXI_RANK_DETAILS.add(new TaxiRanks("Mokopane Taxi Rank", -24.1943, 29.0097, "Limpopo"));

        // Mpumalanga
        TAXI_RANK_DETAILS.add(new TaxiRanks("Nelspruit CBD Rank", -25.4658, 30.9620, "Mpumalanga"));
        TAXI_RANK_DETAILS.add(new TaxiRanks("Emalahleni Taxi Rank", -25.8731, 29.2334, "Mpumalanga"));
        TAXI_RANK_DETAILS.add(new TaxiRanks("Secunda Taxi Rank", -26.5098, 29.2018, "Mpumalanga"));

        // Northern Cape
        TAXI_RANK_DETAILS.add(new TaxiRanks("Kimberley Taxi Rank", -28.7381, 24.7635, "Northern Cape"));
        TAXI_RANK_DETAILS.add(new TaxiRanks("Upington Taxi Rank", -28.4541, 21.2560, "Northern Cape"));
        TAXI_RANK_DETAILS.add(new TaxiRanks("Springbok Taxi Rank", -29.6643, 17.8860, "Northern Cape"));

        // North West
        TAXI_RANK_DETAILS.add(new TaxiRanks("Mafikeng Taxi Rank", -25.8656, 25.6419, "North West"));
        TAXI_RANK_DETAILS.add(new TaxiRanks("Rustenburg Taxi Rank", -25.6706, 27.2423, "North West"));
        TAXI_RANK_DETAILS.add(new TaxiRanks("Klerksdorp Taxi Rank", -26.8730, 26.6648, "North West"));
    }

    @Override
    public void run(String... args) throws Exception {
        taxiRankRepository.deleteAll();
        taxiRankRepository.saveAll(TAXI_RANK_DETAILS);
    }
}
