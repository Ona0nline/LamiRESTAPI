package com.onaonline.lami.lami_backend.rideoptions.taxi;

import com.onaonline.lami.lami_backend.database.details.LamiDriverDetails;
import com.onaonline.lami.lami_backend.database.details.RoutesDetails;
import com.onaonline.lami.lami_backend.database.details.TaxiRankDetails;
import com.onaonline.lami.lami_backend.database.repos.RoutesRepository;
import com.onaonline.lami.lami_backend.database.repos.TaxiRankRepository;
import com.onaonline.lami.lami_backend.util.BoundingBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TaxiService {

    @Autowired
    private TaxiRankRepository taxiRankRepository;

    @Autowired
    private RoutesRepository routesRepository;

    private BoundingBox boundingBox = new BoundingBox();

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
}