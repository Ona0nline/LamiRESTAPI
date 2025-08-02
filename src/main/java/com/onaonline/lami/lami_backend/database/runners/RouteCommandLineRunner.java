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
        routeDetails.add(new RoutesDetails(1L, "MTN Taxi Rank", -26.203049, 27.998500, "Soweto Bara", -26.270759, 27.865854, 18));
        routeDetails.add(new RoutesDetails(1L, "MTN Taxi Rank", -26.203049, 27.998500, "Alexandra", -26.103312, 28.098998, 15));
        routeDetails.add(new RoutesDetails(2L, "Bree Street Taxi Rank", -26.204103, 28.040251, "Randburg CBD", -26.096764, 28.007264, 17));
        routeDetails.add(new RoutesDetails(3L, "Randburg Taxi Rank", -26.096764, 28.007264, "Midrand", -25.999180, 28.127980, 20));

        // Western Cape (rankIds 4,5,6)
        routeDetails.add(new RoutesDetails(4L, "Cape Town Station Deck", -33.925840, 18.425890, "Khayelitsha", -34.038200, 18.673850, 25));
        routeDetails.add(new RoutesDetails(4L, "Cape Town Station Deck", -33.925840, 18.425890, "Mitchells Plain", -34.049460, 18.622390, 23));
        routeDetails.add(new RoutesDetails(5L, "Bellville Taxi Rank", -33.898540, 18.629510, "Parow", -33.899350, 18.601400, 14));
        routeDetails.add(new RoutesDetails(6L, "Mitchells Plain Town Centre", -34.048680, 18.624390, "Cape Town CBD", -33.924870, 18.424055, 30));

        // KwaZulu-Natal (rankIds 7,8,9)
        routeDetails.add(new RoutesDetails(7L, "Warwick Junction", -29.853270, 31.008900, "Umlazi", -29.964140, 30.870830, 18));
        routeDetails.add(new RoutesDetails(7L, "Warwick Junction", -29.853270, 31.008900, "KwaMashu", -29.718260, 30.990750, 17));
        routeDetails.add(new RoutesDetails(8L, "Bridge City Taxi Rank", -29.698790, 30.989290, "Durban CBD", -29.858680, 31.021840, 16));
        routeDetails.add(new RoutesDetails(9L, "Pinetown CBD Rank", -29.818760, 30.865040, "New Germany", -29.821960, 30.889750, 15));

        // Eastern Cape (rankIds 10,11,12)
        routeDetails.add(new RoutesDetails(10L, "North End Taxi Rank", -33.951640, 25.602510, "Motherwell", -33.832030, 25.621700, 22));
        routeDetails.add(new RoutesDetails(11L, "Mdantsane Taxi Rank", -32.943360, 27.788020, "East London CBD", -33.015290, 27.911630, 20));
        routeDetails.add(new RoutesDetails(12L, "Uitenhage Taxi Rank", -33.757690, 25.401510, "Port Elizabeth CBD", -33.960800, 25.602180, 18));

        // Free State (rankIds 13,14,15)
        routeDetails.add(new RoutesDetails(13L, "Bloemfontein CBD Rank", -29.117430, 26.215470, "Botshabelo", -29.234380, 26.716620, 25));
        routeDetails.add(new RoutesDetails(14L, "Welkom Taxi Rank", -27.994550, 26.720460, "Thabong", -28.008600, 26.791620, 15));
        routeDetails.add(new RoutesDetails(15L, "Botshabelo Taxi Rank", -29.233920, 26.714920, "Bloemfontein CBD", -29.117430, 26.215470, 25));

        // Limpopo (rankIds 16,17,18)
        routeDetails.add(new RoutesDetails(16L, "Polokwane Taxi Rank", -23.904500, 29.468850, "Seshego", -23.870190, 29.386180, 12));
        routeDetails.add(new RoutesDetails(17L, "Thohoyandou Taxi Rank", -22.974230, 30.453580, "Sibasa", -22.950760, 30.471490, 10));
        routeDetails.add(new RoutesDetails(18L, "Mokopane Taxi Rank", -24.194100, 29.009150, "Mahwelereng", -24.164820, 28.980140, 14));

        // Mpumalanga (rankIds 19,20,21)
        routeDetails.add(new RoutesDetails(19L, "Nelspruit CBD Rank", -25.474480, 30.970020, "KaNyamazane", -25.490570, 31.048180, 17));
        routeDetails.add(new RoutesDetails(20L, "Emalahleni Taxi Rank", -25.875150, 29.233230, "Ogies", -26.001290, 29.049950, 20));
        routeDetails.add(new RoutesDetails(21L, "Secunda Taxi Rank", -26.516130, 29.203370, "Evander", -26.519430, 29.096390, 15));

        // Northern Cape (rankIds 22,23,24)
        routeDetails.add(new RoutesDetails(22L, "Kimberley Taxi Rank", -28.738300, 24.763430, "Galeshewe", -28.726210, 24.738160, 14));
        routeDetails.add(new RoutesDetails(23L, "Upington Taxi Rank", -28.452730, 21.256510, "Keimoes", -28.703010, 20.980300, 25));
        routeDetails.add(new RoutesDetails(24L, "Springbok Taxi Rank", -29.664490, 17.886740, "Okiep", -29.630170, 17.875640, 20));

        // North West (rankIds 25,26,27)
        routeDetails.add(new RoutesDetails(25L, "Mafikeng Taxi Rank", -25.865750, 25.644150, "Mmabatho", -25.852560, 25.621390, 10));
        routeDetails.add(new RoutesDetails(26L, "Rustenburg Taxi Rank", -25.672130, 27.241720, "Tlhabane", -25.669820, 27.206700, 12));
        routeDetails.add(new RoutesDetails(27L, "Klerksdorp Taxi Rank", -26.871180, 26.664220, "Jouberton", -26.826000, 26.617080, 15));

        // Additional cross-province / major routes
        routeDetails.add(new RoutesDetails(1L, "MTN Taxi Rank", -26.203049, 27.998500, "Pretoria CBD", -25.746111, 28.188056, 35));
        routeDetails.add(new RoutesDetails(4L, "Cape Town Station Deck", -33.925840, 18.425890, "Somerset West", -34.079020, 18.856130, 40));
        routeDetails.add(new RoutesDetails(7L, "Warwick Junction", -29.853270, 31.008900, "Pietermaritzburg", -29.603560, 30.379010, 40));
    }


    @Override
    public void run(String... args) throws Exception {
        routeRepository.deleteAll();
        routeRepository.saveAll(routeDetails);
    }
}
