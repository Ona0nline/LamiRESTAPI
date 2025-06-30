package com.onaonline.lami.lami_backend.rideoptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//What user passes in
@Getter
@RequiredArgsConstructor
public class RideRequestDTO {
    private Long id;
    private double startLocationLat;
    private double startLocationLong;
    private double endLocationLat;
    private double endLocationLong;

}
