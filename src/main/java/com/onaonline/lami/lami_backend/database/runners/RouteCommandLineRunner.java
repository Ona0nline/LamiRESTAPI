package com.onaonline.lami.lami_backend.database.runners;

import com.onaonline.lami.lami_backend.database.details.RoutesDetails;
import com.onaonline.lami.lami_backend.database.repos.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RouteCommandLineRunner implements CommandLineRunner {

    private static List<RoutesDetails> routeDetails = new ArrayList<>();

    @Autowired
    private RoutesRepository routeRepository;

    static {
        // Gauteng (rankIds 1,2,3)
        routeDetails.add(new RoutesDetails(1L, "MTN Taxi Rank", "Soweto Bara", 18));
        routeDetails.add(new RoutesDetails(1L, "MTN Taxi Rank", "Alexandra", 15));
        routeDetails.add(new RoutesDetails(2L, "Bree Street Taxi Rank", "Randburg CBD", 17));
        routeDetails.add(new RoutesDetails(3L, "Randburg Taxi Rank", "Midrand", 20));

        // Western Cape (rankIds 4,5,6)
        routeDetails.add(new RoutesDetails(4L, "Cape Town Station Deck", "Khayelitsha", 25));
        routeDetails.add(new RoutesDetails(4L, "Cape Town Station Deck", "Mitchells Plain", 23));
        routeDetails.add(new RoutesDetails(5L, "Bellville Taxi Rank", "Parow", 14));
        routeDetails.add(new RoutesDetails(6L, "Mitchells Plain Town Centre", "Cape Town CBD", 30));

        // KwaZulu-Natal (rankIds 7,8,9)
        routeDetails.add(new RoutesDetails(7L, "Warwick Junction", "Umlazi", 18));
        routeDetails.add(new RoutesDetails(7L, "Warwick Junction", "KwaMashu", 17));
        routeDetails.add(new RoutesDetails(8L, "Bridge City Taxi Rank", "Durban CBD", 16));
        routeDetails.add(new RoutesDetails(9L, "Pinetown CBD Rank", "New Germany", 15));

        // Eastern Cape (rankIds 10,11,12)
        routeDetails.add(new RoutesDetails(10L, "North End Taxi Rank", "Motherwell", 22));
        routeDetails.add(new RoutesDetails(11L, "Mdantsane Taxi Rank", "East London CBD", 20));
        routeDetails.add(new RoutesDetails(12L, "Uitenhage Taxi Rank", "Port Elizabeth CBD", 18));

        // Free State (rankIds 13,14,15)
        routeDetails.add(new RoutesDetails(13L, "Bloemfontein CBD Rank", "Botshabelo", 25));
        routeDetails.add(new RoutesDetails(14L, "Welkom Taxi Rank", "Thabong", 15));
        routeDetails.add(new RoutesDetails(15L, "Botshabelo Taxi Rank", "Bloemfontein CBD", 25));

        // Limpopo (rankIds 16,17,18)
        routeDetails.add(new RoutesDetails(16L, "Polokwane Taxi Rank", "Seshego", 12));
        routeDetails.add(new RoutesDetails(17L, "Thohoyandou Taxi Rank", "Sibasa", 10));
        routeDetails.add(new RoutesDetails(18L, "Mokopane Taxi Rank", "Mahwelereng", 14));

        // Mpumalanga (rankIds 19,20,21)
        routeDetails.add(new RoutesDetails(19L, "Nelspruit CBD Rank", "KaNyamazane", 17));
        routeDetails.add(new RoutesDetails(20L, "Emalahleni Taxi Rank", "Ogies", 20));
        routeDetails.add(new RoutesDetails(21L, "Secunda Taxi Rank", "Evander", 15));

        // Northern Cape (rankIds 22,23,24)
        routeDetails.add(new RoutesDetails(22L, "Kimberley Taxi Rank", "Galeshewe", 14));
        routeDetails.add(new RoutesDetails(23L, "Upington Taxi Rank", "Keimoes", 25));
        routeDetails.add(new RoutesDetails(24L, "Springbok Taxi Rank", "Okiep", 20));

        // North West (rankIds 25,26,27)
        routeDetails.add(new RoutesDetails(25L, "Mafikeng Taxi Rank", "Mmabatho", 10));
        routeDetails.add(new RoutesDetails(26L, "Rustenburg Taxi Rank", "Tlhabane", 12));
        routeDetails.add(new RoutesDetails(27L, "Klerksdorp Taxi Rank", "Jouberton", 15));

        // Additional cross-province / major routes
        routeDetails.add(new RoutesDetails(1L, "MTN Taxi Rank", "Pretoria CBD", 35));
        routeDetails.add(new RoutesDetails(4L, "Cape Town Station Deck", "Somerset West", 40));
        routeDetails.add(new RoutesDetails(7L, "Warwick Junction", "Pietermaritzburg", 40));
    }

    @Override
    public void run(String... args) throws Exception {
        routeRepository.deleteAll();
        routeRepository.saveAll(routeDetails);
    }
}
