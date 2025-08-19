package com.onaonline.lami.lami_backend.database.runners;

import com.onaonline.lami.lami_backend.LamiBackendApplication;
import com.onaonline.lami.lami_backend.database.details.Route;
import com.onaonline.lami.lami_backend.database.repos.RouteRepository;
import com.onaonline.lami.lami_backend.externalApis.osrm.OSRMService;
import com.onaonline.lami.lami_backend.externalApis.osrm.OsrmMetaData;
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

    @Autowired
    private OSRMService osrmService;

    @Autowired
    private RouteRepository routeRepository;

    public RouteCLR(TaxiService taxiService) {
        this.taxiService = taxiService;
    }


    public void getTaxiMetaData() throws Exception {
        Map<String, Map<String, List<String>>> taxiRanks = new HashMap<>();

        Map<String, List<String>> gautengRanks = new HashMap<>();
        gautengRanks.put("MTN Noord", List.of("Sandton", "Rosebank", "Randburg"));
        taxiRanks.put("Gauteng", gautengRanks);

        Map<String, List<String>> limpopoRanks = new HashMap<>();
        limpopoRanks.put("Polokwane Taxi Rank", List.of("Seshego", "Lebowakgomo", "Mankweng"));
        limpopoRanks.put("Thohoyandou Taxi Rank", List.of("Louis Trichardt", "Giyani", "Elim"));
        taxiRanks.put("Limpopo", limpopoRanks);

        Map<String, List<String>> KZNRanks = new HashMap<>();
        KZNRanks.put("Tonggaat Taxi Rank", List.of("Durban Station", "Ballito", "Umhlanga"));
        taxiRanks.put("Kwa-Zulu Natal", KZNRanks);

        Map<String, List<String>> ecRanks = new HashMap<>();
        ecRanks.put("Port Elizabeth Taxi Rank", List.of("Uitenhage", "Humansdorp", "Jeffreys Bay"));
        taxiRanks.put("Eastern Cape", ecRanks);


        Map<String, List<String>> fsRanks = new HashMap<>();
        fsRanks.put("Bloemfontein Taxi Rank", List.of("Botshabelo", "Thaba Nchu", "Dewetsdorp"));
        taxiRanks.put("Free State", fsRanks);

        Map<String, List<String>> ncRanks = new HashMap<>();
        ncRanks.put("Upington Taxi Rank", List.of("Keimoes", "Kakamas", "Groblershoop"));
        taxiRanks.put("Northern Cape", ncRanks);

        Map<String, List<String>> nwRanks = new HashMap<>();
        nwRanks.put("Rustenburg Taxi Rank", List.of("Brits", "Koster", "Swartruggens"));
        nwRanks.put("Mahikeng Taxi Rank", List.of("Zeerust", "Lichtenburg", "Vryburg"));
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

        // RankID counter
        int rankID = 1;

        for (Map.Entry<String, Map<String, List<String>>> provinceEntry : taxiRanks.entrySet()) {
            String province = provinceEntry.getKey();
            Map<String, List<String>> rankRoutes = provinceEntry.getValue();

            System.out.println("\nProcessing province: " + province);

            // Process each taxi rank in the province
            for (Map.Entry<String, List<String>> rankEntry : rankRoutes.entrySet()) {
                String taxiRank = rankEntry.getKey();
                List<String> destinations = rankEntry.getValue();

                System.out.println("Processing routes for " + taxiRank + " (RankID: " + rankID + "):");

                // Call OSRM service for each destination
                for (String destination : destinations) {
                    OsrmMetaData osrmMetaData = osrmService.getOsrmMetaData(taxiRank, destination);
                    System.out.println("Routes: " + osrmService.getOsrmMetaData(taxiRank, destination));

                    Route metadata = new Route(osrmMetaData.getWeight(), osrmMetaData.getDistance(), osrmMetaData.getDuration(), osrmMetaData.getRouteCoords(), rankID);
                    System.out.println("LineString before save: " + osrmMetaData.getRouteCoords().toText());
                    routeRepository.save(metadata);
                    System.out.println("Saved route with ID: " + metadata.getId());

                }

                // Increment rankID for the next taxi rank
                rankID++;
            }
        }


    }

    @Override
    public void run(String... args) throws Exception {
        getTaxiMetaData();
    }

}