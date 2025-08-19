package com.onaonline.lami.lami_backend.rideoptions.taxi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onaonline.lami.lami_backend.database.details.RoutesDetails;
import com.onaonline.lami.lami_backend.database.details.TaxiRankDetails;
import com.onaonline.lami.lami_backend.database.repos.RouteRepository;
import com.onaonline.lami.lami_backend.database.repos.RoutesRepository;
import com.onaonline.lami.lami_backend.database.repos.TaxiRankRepository;
import com.onaonline.lami.lami_backend.externalApis.osrm.OSRMService;
import com.onaonline.lami.lami_backend.externalApis.osrm.OsrmMetaData;
import com.onaonline.lami.lami_backend.util.BoundingBox;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TaxiService {

    @Autowired
    private OSRMService osrmService;

    @Autowired
    private final RestTemplate restTemplate;
    @Autowired
    private final ObjectMapper objectMapper;

    @Autowired
    private TaxiRankRepository taxiRankRepository;

    @Autowired
    private RoutesRepository routesRepository;

    @Autowired
    private RouteRepository routeRepository;

    private BoundingBox boundingBox = new BoundingBox();

    public TaxiService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public ArrayList<Map<String, Object>> nearbyRanks(double startLocLat, double startLocLong){
        BoundingBox boundingBox1 = boundingBox.calculateBoundingBox(startLocLat,startLocLong,5);
        List<TaxiRankDetails> nearbyTaxiRanks = taxiRankRepository.findByLatitudeBetweenAndLongitudeBetween(boundingBox1.latMin,
                boundingBox1.latMax, boundingBox1.lonMin, boundingBox1.lonMax);

        ArrayList<Map<String, Object>> taxiRanks = new ArrayList<>();

        for(TaxiRankDetails taxiRank : nearbyTaxiRanks){
            taxiRanks.add(
                    Map.of(
                            "id", taxiRank.getId(),
                            "name", taxiRank.getName(),
                            "province",taxiRank.getProvince(),
                            "latitude",taxiRank.getLatitude(),
                            "longitude", taxiRank.getLongitude()
                    )
            );
        }

        return taxiRanks;

    }

    public List<Map<String, Object>> routeByRankid(Long id){

        List<RoutesDetails> databaseRoutes = routesRepository.findByRankId(id);
        System.out.println("Exisiting routes from database " + databaseRoutes);
        ArrayList<Map<String, Object>> routes = new ArrayList<>();
        if(!databaseRoutes.isEmpty()){
            for(RoutesDetails route : databaseRoutes){
                routes.add(Map.of(
                        "id", route.getId(),
                        "startLocation",route.getStartLocation(),
                        "startLat", route.getStartLat(),
                        "startLong", route.getEndLat(),
                        "endLat", route.getEndLat(),
                        "endLong", route.getEndLong(),
                        "endLocation",route.getEndLocation(),
                        "fare",route.getFare(),
                        "rankID",route.getRankId()

                ));
            }
        }

        return routes;
    }

    public List<Long> rankIdbyproximity(double lon, double lat){
        List<Long> rankIds = routeRepository.findRouteIdsContainingPoint(lon,lat);

        if (rankIds.isEmpty()){
            System.out.println("No taxi ranks that pass along your location.");
        }

        return rankIds;

    }


}