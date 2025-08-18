package com.onaonline.lami.lami_backend.externalApis.osrm;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onaonline.lami.lami_backend.externalApis.geocoding.GeocodeService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OSRMService {

    @Autowired
    private final RestTemplate restTemplate;
    @Autowired
    private final ObjectMapper objectMapper;
    @Autowired
    private final GeocodeService geocodeService;

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

//    public static void main(String[] args) throws Exception {
//        String apiresponse = restTemplate.getForObject(apiUrl2Points("Braamfontein Johannesburg South Africa", "Wonderpark mall"), String.class);
//        JsonNode root = objectMapper.readTree(apiresponse);
//        JsonNode results = root.path("results");
//
//        System.out.println(results);
//    }
}
