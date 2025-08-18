package com.onaonline.lami.lami_backend.externalApis.osrm;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onaonline.lami.lami_backend.externalApis.geocoding.GeocodeResponseDTO;
import com.onaonline.lami.lami_backend.externalApis.geocoding.GeocodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class OSRMService {

    @Autowired
    private static RestTemplate restTemplate = new RestTemplate();
    private static ObjectMapper objectMapper = new ObjectMapper();

//    public OSRMService(RestTemplate restTemplate, ObjectMapper objectMapper){
//        this.restTemplate = restTemplate;
//        this.objectMapper = objectMapper;
//    }

    @Autowired
    private static GeocodeService geocodeService = new GeocodeService(restTemplate, objectMapper);

    private static String apiUrl2Points(String startLocation, String endLocation) throws Exception {
        double geocodedStartLat = geocodeService.geocodeAddress(startLocation).getLatitude();
        double geocodedStartLong = geocodeService.geocodeAddress(startLocation).getLongitude();

        double geocodedEndLat = geocodeService.geocodeAddress(endLocation).getLatitude();
        double geocodedEndLong = geocodeService.geocodeAddress(endLocation).getLongitude();

        return "http://localhost:5000/route/v1/driving/"
                + geocodedStartLat + "," +geocodedStartLong
                + ";" + geocodedEndLat + "," + geocodedEndLong
                + "?geometries=geojson&overview=full";
    }

    public static void main(String[] args) throws Exception {
        String apiresponse = restTemplate.getForObject(apiUrl2Points("Braamfontein, Johannesburg, South Africa", "Wonderpark mall"), String.class);
        JsonNode root = objectMapper.readTree(apiresponse);
        JsonNode results = root.path("results");

        System.out.println(results);
    }
}
