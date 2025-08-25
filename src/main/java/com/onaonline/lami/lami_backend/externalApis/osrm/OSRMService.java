package com.onaonline.lami.lami_backend.externalApis.osrm;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onaonline.lami.lami_backend.database.details.TaxiRanks;
import com.onaonline.lami.lami_backend.database.repos.TaxiRankRepository;
import com.onaonline.lami.lami_backend.externalApis.geocoding.GeocodeService;
import org.apache.catalina.core.ApplicationContext;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class OSRMService {

    @Autowired
    private final RestTemplate restTemplate;
    @Autowired
    private final ObjectMapper objectMapper;
    @Autowired
    private final GeocodeService geocodeService;

    @Autowired
    private TaxiRankRepository taxiRankRepository;

    @Autowired
    // Tell Spring: "Use THIS constructor for injection"
//    To have two constructors in Springboot (all args + no args), autowire the all args one
    public OSRMService(RestTemplate restTemplate, ObjectMapper objectMapper, GeocodeService geocodeService) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.geocodeService = geocodeService;
    }


    public String apiUrl2Points(String startLocation, String endLocation) throws Exception {
        double geocodedStartLat = geocodeService.geocodeAddress(startLocation).getLatitude();
        double geocodedStartLong = geocodeService.geocodeAddress(startLocation).getLongitude();

        double geocodedEndLat = geocodeService.geocodeAddress(endLocation).getLatitude();
        double geocodedEndLong = geocodeService.geocodeAddress(endLocation).getLongitude();

        return "http://router.project-osrm.org/route/v1/driving/"
                + geocodedStartLong + "," +geocodedStartLat
                + ";" + geocodedEndLong + "," + geocodedEndLat
                + "?geometries=geojson&overview=full";
    }

    public OsrmMetaData getOsrmMetaData(String start, String end) throws Exception {
        String apiresponse = restTemplate.getForObject(apiUrl2Points(start, end), String.class);
        JsonNode root = objectMapper.readTree(apiresponse);
        JsonNode routes = root.path("routes");

        int weight = routes.get(0).get("legs").get(0).get("weight").asInt();
        int duration = routes.get(0).get("legs").get(0).get("duration").asInt();
        int distance = routes.get(0).get("legs").get(0).get("distance").asInt();

        GeometryFactory geometryFactory = new GeometryFactory();
        JsonNode routeCoordinates = objectMapper.convertValue(routes.get(0).get("geometry").get("coordinates"), new TypeReference<>() {});
        Coordinate[] coordinates = new Coordinate[routeCoordinates.size()];
        for (int i = 0; i < routeCoordinates.size(); i++) {
            double lon = routeCoordinates.get(i).get(0).asDouble();
            double lat = routeCoordinates.get(i).get(1).asDouble();
            coordinates[i] = new Coordinate(lon, lat);
        }

        LineString line = geometryFactory.createLineString(coordinates);
        System.out.println("Full OSRM Response: " + routes);
        System.out.println("Coordinates: " + routeCoordinates);

        Optional<TaxiRanks> optionaltaxiRank = taxiRankRepository.findByName(start);
        System.out.println("Taxi rank in db?: " + optionaltaxiRank.get().getName() + "id: " + optionaltaxiRank.get().getId());
        TaxiRanks taxiRank = optionaltaxiRank.get();
        return new OsrmMetaData(weight,duration, distance, line, taxiRank);

    }

}
