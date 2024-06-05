package com.green.webclientPlant.floating.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PlantFloatingGetReq {
    @Schema(defaultValue = "json")
    private String type;
    @Schema(defaultValue = "5000")
    private String numOfRows;
    @Schema(defaultValue = "1")
    private String pageNo;
}
