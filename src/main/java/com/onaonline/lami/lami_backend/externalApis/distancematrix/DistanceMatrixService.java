package com.onaonline.lami.lami_backend.externalApis.distancematrix;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public DistanceMatrixResponseDTO distanceCalculator(String startLocation, String endLocation) throws Exception {
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json\n" +
                "  ?destinations=" + endLocation +
                "  &origins=" + startLocation +
                "  &units=metric" +
                "&mode=transit" +
                "  &key=" + apiKey;

        String apiresponse = restTemplate.getForObject(url, String.class);
        JsonNode root = objectMapper.readTree(apiresponse);
        System.out.println(apiresponse);
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
            fare = "R" + (475 * (distanceMeters / 1000)) / 100;
            return new DistanceMatrixResponseDTO(durationSeconds, distanceMeters, fare);

        }
        else {
            throw new Exception();
        }


    }

//
//    public static double fareCalculation(){
//
//    }


}
