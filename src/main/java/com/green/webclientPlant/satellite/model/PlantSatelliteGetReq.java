package com.green.webclientPlant.satellite.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PlantSatelliteGetReq {
    @Schema(defaultValue = "json")
    private String type;
    @Schema(defaultValue = "5000")
    private String numOfRows;
    @Schema(defaultValue = "1")
    private String pageNo;
}
