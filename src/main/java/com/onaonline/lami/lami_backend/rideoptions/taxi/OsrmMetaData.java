package com.onaonline.lami.lami_backend.rideoptions.taxi;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OsrmMetaData {
    private int weight;
    private  int duration;
    private  int distance;
}
