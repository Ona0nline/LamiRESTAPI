package com.onaonline.lami.lami_backend.externalApis.distancematrix;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class DistanceMatrixService {
    @Value("${google.api.key}")
    private String apiKey;
    @Autowired
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public DistanceMatrixService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    private String apiUrl(String startLocation, String endLocation){
        String encodedStart = URLEncoder.encode(startLocation, StandardCharsets.UTF_8);
        String encodedEnd = URLEncoder.encode(endLocation, StandardCharsets.UTF_8);

        return "https://maps.googleapis.com/maps/api/distancematrix/json" +
                "?destinations=" + encodedEnd +
                "&origins=" + encodedStart +
                "&units=metric" +
                "&mode=transit" +
                "&key=" + apiKey;

    }

    public DistanceMatrixResponseDTO distanceCalculatorLami(String startLocation, String endLocation) throws Exception {

        String apiresponse = restTemplate.getForObject(apiUrl(startLocation,endLocation), String.class);
        JsonNode root = objectMapper.readTree(apiresponse);
        JsonNode element = root
                .path("rows")
                .get(0)
                .path("elements")
                .get(0);

        String status = element.path("status").asText();
        if(status.equals("OK")){
            String fare;
            double durationSeconds = element
                    .path("duration")
                    .path("value").asDouble();

            double distanceMeters = element
                    .path("distance")
                    .path("value").asDouble();

            if(durationSeconds <= 900){
                fare = "R" + (2500 / 100);
                return new DistanceMatrixResponseDTO(durationSeconds, distanceMeters, fare);
            }
            fare = "R" + String.format("%.2f", (475 * (distanceMeters / 1000.0)) / 100);
            return new DistanceMatrixResponseDTO(durationSeconds, distanceMeters, fare);

        }
        else {
            throw new Exception();
        }


    }

    public DistanceMatrixLuxResponseDTO distanceCalculatorLux(String startLocation, String endLocation) throws Exception {

        String apiresponse = restTemplate.getForObject(apiUrl(startLocation,endLocation), String.class);
        System.out.println(apiresponse);
        JsonNode root = objectMapper.readTree(apiresponse);
        JsonNode element = root
                .path("rows")
                .get(0)
                .path("elements")
                .get(0);

        String status = element.path("status").asText();
        if(status.equals("OK")){

            double durationSeconds = element
                    .path("duration")
                    .path("value").asDouble();

            double distanceMeters = element
                    .path("distance")
                    .path("value").asDouble();

            if(durationSeconds <= 900){
                double standardfare = (2500 / 100);
                return new DistanceMatrixLuxResponseDTO(durationSeconds, distanceMeters, standardfare);
            }

            double fare = (475 * (distanceMeters / 1000.0)) / 100;
            return new DistanceMatrixLuxResponseDTO(durationSeconds, distanceMeters, fare);

        }
        else {
            throw new Exception();
        }
    }




}
