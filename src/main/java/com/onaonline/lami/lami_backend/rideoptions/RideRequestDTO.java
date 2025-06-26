package com.onaonline.lami.lami_backend.rideoptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//What user passes in
@RequiredArgsConstructor
public class RideRequestDTO {
    @Getter
    private String startLocation;
    @Getter
    private String endLocation;



}
