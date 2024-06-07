package com.green.webclientPlant.outpatient.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class OutPlantGetReq {
    @Schema(defaultValue = "json")
    private String type;
    @Schema(defaultValue = "1", description = "1-국명/2-학명/3-국명일치/4-학명일치")
    private String st;
    @Schema(defaultValue = "미국", description = "검색대상어")
    private String sw;
    @Schema(defaultValue = "1000")
    private String numOfRows;
    @Schema(defaultValue = "1")
    private String pageNo;
}
