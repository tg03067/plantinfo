package com.green.webclientPlant.floating;

import com.green.webclientPlant.common.ResultDto;
import com.green.webclientPlant.floating.model.PlantFloatingEntity;
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
@RequestMapping("api/openapi/plant/floating")
@Slf4j
@Tag(name = "부유식물API" ,description = "부유식물 CRUD")
public class WebClientPlantFloatingController {
    private final WebClientPlantFloatingService service;

    @GetMapping
    @Operation(summary = "부유식물조회")
    public ResultDto<List<PlantFloatingEntity>> getPlant(@ParameterObject @ModelAttribute PlantSatelliteGetReq q){
        List<PlantFloatingEntity> list = service.getPlant(q);
        log.info(list.toString());
        return ResultDto.<List<PlantFloatingEntity>>builder().
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
