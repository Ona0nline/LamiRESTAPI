package com.onaonline.lami.lami_backend.externalApis.geocoding;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeocodeService {
    @Value("${google.api.key}")
    private String apiKey;

    @Autowired
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public GeocodeService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }


    public GeocodeResponseDTO geocodeAddress(String address) throws Exception {
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address="
                + address.replace(" ", "+")
                + "&key=" + apiKey;

        String apiresponse = restTemplate.getForObject(url,String.class);
        JsonNode root = objectMapper.readTree(apiresponse);
        JsonNode results = root.path("results");

        if (results.isArray() && !results.isEmpty()) {
            JsonNode firstResult = results.get(0);
            String formattedAddress = firstResult.path("formatted_address").asText();
            double lat = firstResult.path("geometry").path("location").path("lat").asDouble();
            double lng = firstResult.path("geometry").path("location").path("lng").asDouble();

            return new GeocodeResponseDTO(formattedAddress, lat, lng);
        } else {
            throw new Exception("No results from geocoding API for address: " + address);
        }

    }
}
