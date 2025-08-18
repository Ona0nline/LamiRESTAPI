package com.onaonline.lami.lami_backend.database.runners;

import com.onaonline.lami.lami_backend.LamiBackendApplication;
import com.onaonline.lami.lami_backend.rideoptions.taxi.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RouteCLR implements CommandLineRunner {

    @Autowired
    private TaxiService taxiService;

    public RouteCLR(TaxiService taxiService) {
        this.taxiService = taxiService;
    }

    public void getTaxiMetaData() throws Exception {
        Map<String, Map<String, List<String>>> taxiRanks = new HashMap<>();

        Map<String, List<String>> gautengRanks = new HashMap<>();
        gautengRanks.put("MTN Noord", List.of("Sandton", "Rosebank", "Randburg"));
        gautengRanks.put("Bree", List.of("Soweto", "Jabulani Mall", "Westgate"));

        taxiRanks.put("Gauteng", gautengRanks);

        Map<String, List<String>> limpopoRanks = new HashMap<>();
        limpopoRanks.put("Polokwane Taxi Rank", List.of("Seshego", "Lebowakgomo", "Mankweng"));
        limpopoRanks.put("Thohoyandou Taxi Rank", List.of("Louis Trichardt", "Giyani", "Elim"));

        taxiRanks.put("Limpopo", limpopoRanks);

        Map<String, List<String>> KZNRanks = new HashMap<>();
        KZNRanks.put("Verulam Taxi Rank", List.of("Phoenix", "Durban Station", "Cornubia"));
        KZNRanks.put("Tonggaat Taxi Rank", List.of("Durban Station", "Ballito", "Umhlanga"));

        taxiRanks.put("Kwa-Zulu Natal", KZNRanks);

        Map<String, List<String>> wcRanks = new HashMap<>();
        wcRanks.put("BellVille Taxi Rank", List.of("Cape Town City Bowl", "Claremont", "Wynberg"));
        wcRanks.put("Cape Town City Bowl Taxi Rank", List.of("Observatory", "Mowbray", "Rondebosch"));

        taxiRanks.put("Western Cape", wcRanks);

        Map<String, List<String>> ecRanks = new HashMap<>();
        ecRanks.put("Umtata Taxi Rank", List.of("Butterworth", "East London", "Queenstown"));
        ecRanks.put("Port Elizabeth Taxi Rank", List.of("Uitenhage", "Humansdorp", "Jeffreys Bay"));

        taxiRanks.put("Eastern Cape", ecRanks);

        Map<String, List<String>> mpumalangaRanks = new HashMap<>();
        mpumalangaRanks.put("Nelspruit Taxi Rank", List.of("White River", "Mbombela", "Hazyview"));
        mpumalangaRanks.put("Kildare Taxi Rank", List.of(": Barberton", "Sabie", "Lydenburg"));

        taxiRanks.put("Mpumalanga", mpumalangaRanks);

        Map<String, List<String>> fsRanks = new HashMap<>();
        fsRanks.put("Bloemfontein Taxi Rank", List.of("Botshabelo", "Thaba Nchu", "Dewetsdorp"));
        fsRanks.put("Welkom Taxi Rank", List.of("Odendaalsrus", "Virginia", "Theunissen"));

        taxiRanks.put("Free State", fsRanks);

        Map<String, List<String>> ncRanks = new HashMap<>();
        ncRanks.put("MTN Noord", List.of("Upington", "De Aar", "Colesberg"));
        ncRanks.put("Bree", List.of("Keimoes", "Kakamas", "Groblershoop"));

        taxiRanks.put("Northern Cape", ncRanks);

        Map<String, List<String>> nwRanks = new HashMap<>();
        nwRanks.put("MTN Noord", List.of("Brits", "Koster", "Swartruggens"));
        nwRanks.put("Bree", List.of("Zeerust", "Lichtenburg", "Vryburg"));

        taxiRanks.put("North West", nwRanks);

//        Parsing

        List<Map<String, List<String>>> ranksRoutes = new ArrayList<>();
        List<Set<String>> firstValues = new ArrayList<>();
        List<Collection<List<String>>> secondValues = new ArrayList<>();

        for (Map<String, List<String>> route : taxiRanks.values()) {
            ranksRoutes.add(route);
            System.out.println(route);

        }

        for (Map<String, List<String>> rankRoute : ranksRoutes) {
            firstValues.add(rankRoute.keySet());
            secondValues.add(rankRoute.values());
        }

        for (Map.Entry<String, Map<String, List<String>>> provinceEntry : taxiRanks.entrySet()) {
            String province = provinceEntry.getKey();
            Map<String, List<String>> rankRoutes = provinceEntry.getValue();

            System.out.println("\nProcessing province: " + province);

            // Process each taxi rank in the province
            for (Map.Entry<String, List<String>> rankEntry : rankRoutes.entrySet()) {
                String taxiRank = rankEntry.getKey();
                List<String> destinations = rankEntry.getValue();

                System.out.println("Processing routes for " + taxiRank + ":");

                // Call OSRM service for each destination
                for (String destination : destinations) {
                    System.out.println("  Route from " + taxiRank + " to " + destination);
                    taxiService.getOsrmMetaData(taxiRank, destination);
                    System.out.println("Routes: " + taxiService.getOsrmMetaData(taxiRank, destination));
                }
            }
        }


    }

    @Override
    public void run(String... args) throws Exception {
//        getTaxiMetaData();
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(LamiBackendApplication.class, args);

        // Get the runner instance from Spring context
        RouteCLR runner = context.getBean(RouteCLR.class);
        runner.getTaxiMetaData();


    }
}

