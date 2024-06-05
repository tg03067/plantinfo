package com.green.webclientPlant.plantencyclopedia.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PlantEncyclopediaGetReq {
    @Schema(defaultValue = "json")
    private String type;
    @Schema(defaultValue = "2024")
    private String stdt;
    @Schema(defaultValue = "5000")
    private String numOfRows;
    @Schema(defaultValue = "1")
    private String pageNo;
}
