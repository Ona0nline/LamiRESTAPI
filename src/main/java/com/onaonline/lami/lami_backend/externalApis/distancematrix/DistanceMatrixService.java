package com.onaonline.lami.lami_backend.externalApis.distancematrix;

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

    public double distanceCalculator(String startLocation, String endLocation){
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json\n" +
                "  ?destinations=" + endLocation +
                "  &origins=" + startLocation +
                "  &units=metric" +
                "&mode=transit" +
                "  &key=" + apiKey;
        return 2.2;
    }
}
