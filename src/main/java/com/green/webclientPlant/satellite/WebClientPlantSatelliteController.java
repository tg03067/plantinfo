package com.green.webclientPlant.satellite;

import com.green.webclientPlant.common.ResultDto;
import com.green.webclientPlant.satellite.model.PlantSatelliteEntity;
import com.green.webclientPlant.satellite.model.PlantSatelliteGetReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/openapi/plant/satellite")
@Slf4j
@Tag(name = "식물종자API" ,description = "식물종자 CRUD")
public class WebClientPlantSatelliteController {
    private final WebClientPlantSatelliteService service;

    @GetMapping
    @Operation(summary = "식물종자조회")
    public ResultDto<List<PlantSatelliteEntity>> getPlant(@ParameterObject @ModelAttribute PlantSatelliteGetReq q){
        List<PlantSatelliteEntity> list = service.getPlant(q);
        log.info(list.toString());
        return ResultDto.<List<PlantSatelliteEntity>>builder().
                status(HttpStatus.OK).
                message(HttpStatus.OK.toString()).
                data(list).
                build();
    }

    @PostMapping
    public ResultDto<Integer> postPlant(@RequestBody PlantSatelliteGetReq q){
        int result = service.insTest(q);
        return ResultDto.<Integer>builder().
                status(HttpStatus.OK).
                message(HttpStatus.OK.toString()).
                data(result).
                build();
    }
}
