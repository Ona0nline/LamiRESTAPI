package com.onaonline.lami.lami_backend.externalApis.distancematrix;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistanceMatrixResource {

    @Autowired
    private DistanceMatrixService distanceMatrixService;

    @PostMapping("api/distance-matrix")
    public ResponseEntity<?> distanceMatrixing(@RequestBody DistanceMatrixRequestDTO distanceMatrixRequestDTO) throws Exception {
        return ResponseEntity.ok(distanceMatrixService.distanceCalculator(distanceMatrixRequestDTO.getStartLocation(), distanceMatrixRequestDTO.getEndLocation()));
    }
}
