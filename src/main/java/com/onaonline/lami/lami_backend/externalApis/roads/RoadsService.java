package com.onaonline.lami.lami_backend.externalApis.roads;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onaonline.lami.lami_backend.database.repos.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class RoadsService {
    @Value("${google.api.key}")
    private String apiKey;

    @Autowired
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    @Autowired
    private static RoutesRepository routesRepository;

    public RoadsService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

//    Routes repositopry

    public List<HashMap<String, Double>> routePathCoords(double startLat, double startLong, double endLat, double endLong){
        String url = "https://roads.googleapis.com/v1/snapToRoads?path=" + startLat + "," + startLong + "|" + endLat + "," + endLong + "&key=" + apiKey;
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);
        return  new ArrayList<>();
    }
}
