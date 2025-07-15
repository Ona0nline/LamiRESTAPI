package com.onaonline.lami.lami_backend.database.runners;

import com.onaonline.lami.lami_backend.database.details.TaxiRankDetails;
import com.onaonline.lami.lami_backend.database.repos.TaxiRankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaxiRanksCommandLineRunner implements CommandLineRunner {

    private static final List<TaxiRankDetails> taxiRankDetails = new ArrayList<>();

    @Autowired
    private TaxiRankRepository taxiRankRepository;

    static {
        // Gauteng
        taxiRankDetails.add(new TaxiRankDetails("MTN Taxi Rank", -26.2022, 28.0416, "Gauteng"));
        taxiRankDetails.add(new TaxiRankDetails("Bree Street Taxi Rank", -26.2041, 28.0341, "Gauteng"));
        taxiRankDetails.add(new TaxiRankDetails("Randburg Taxi Rank", -26.0945, 28.0077, "Gauteng"));

        // Western Cape
        taxiRankDetails.add(new TaxiRankDetails("Cape Town Station Deck", -33.9249, 18.4241, "Western Cape"));
        taxiRankDetails.add(new TaxiRankDetails("Bellville Taxi Rank", -33.9021, 18.6293, "Western Cape"));
        taxiRankDetails.add(new TaxiRankDetails("Mitchells Plain Town Centre", -34.0491, 18.6266, "Western Cape"));

        // KwaZulu-Natal
        taxiRankDetails.add(new TaxiRankDetails("Warwick Junction", -29.8535, 31.0099, "KwaZulu-Natal"));
        taxiRankDetails.add(new TaxiRankDetails("Bridge City Taxi Rank", -29.7014, 31.0397, "KwaZulu-Natal"));
        taxiRankDetails.add(new TaxiRankDetails("Pinetown CBD Rank", -29.8196, 30.8678, "KwaZulu-Natal"));

        // Eastern Cape
        taxiRankDetails.add(new TaxiRankDetails("North End Taxi Rank", -33.9275, 25.6023, "Eastern Cape"));
        taxiRankDetails.add(new TaxiRankDetails("Mdantsane Taxi Rank", -32.9272, 27.6966, "Eastern Cape"));
        taxiRankDetails.add(new TaxiRankDetails("Uitenhage Taxi Rank", -33.7681, 25.4016, "Eastern Cape"));

        // Free State
        taxiRankDetails.add(new TaxiRankDetails("Bloemfontein CBD Rank", -29.1184, 26.2297, "Free State"));
        taxiRankDetails.add(new TaxiRankDetails("Welkom Taxi Rank", -27.9833, 26.7333, "Free State"));
        taxiRankDetails.add(new TaxiRankDetails("Botshabelo Taxi Rank", -29.2301, 26.7186, "Free State"));

        // Limpopo
        taxiRankDetails.add(new TaxiRankDetails("Polokwane Taxi Rank", -23.9043, 29.4486, "Limpopo"));
        taxiRankDetails.add(new TaxiRankDetails("Thohoyandou Taxi Rank", -22.9747, 30.4527, "Limpopo"));
        taxiRankDetails.add(new TaxiRankDetails("Mokopane Taxi Rank", -24.1943, 29.0097, "Limpopo"));

        // Mpumalanga
        taxiRankDetails.add(new TaxiRankDetails("Nelspruit CBD Rank", -25.4658, 30.9620, "Mpumalanga"));
        taxiRankDetails.add(new TaxiRankDetails("Emalahleni Taxi Rank", -25.8731, 29.2334, "Mpumalanga"));
        taxiRankDetails.add(new TaxiRankDetails("Secunda Taxi Rank", -26.5098, 29.2018, "Mpumalanga"));

        // Northern Cape
        taxiRankDetails.add(new TaxiRankDetails("Kimberley Taxi Rank", -28.7381, 24.7635, "Northern Cape"));
        taxiRankDetails.add(new TaxiRankDetails("Upington Taxi Rank", -28.4541, 21.2560, "Northern Cape"));
        taxiRankDetails.add(new TaxiRankDetails("Springbok Taxi Rank", -29.6643, 17.8860, "Northern Cape"));

        // North West
        taxiRankDetails.add(new TaxiRankDetails("Mafikeng Taxi Rank", -25.8656, 25.6419, "North West"));
        taxiRankDetails.add(new TaxiRankDetails("Rustenburg Taxi Rank", -25.6706, 27.2423, "North West"));
        taxiRankDetails.add(new TaxiRankDetails("Klerksdorp Taxi Rank", -26.8730, 26.6648, "North West"));
    }

    @Override
    public void run(String... args) throws Exception {
        taxiRankRepository.deleteAll();
        taxiRankRepository.saveAll(taxiRankDetails);
    }
}
