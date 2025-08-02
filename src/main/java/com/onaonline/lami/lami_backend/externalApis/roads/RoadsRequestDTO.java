package com.onaonline.lami.lami_backend.externalApis.roads;

import lombok.Data;

@Data
public class RoadsRequestDTO {
    private String startLocation;
    private String endLocation;
}
