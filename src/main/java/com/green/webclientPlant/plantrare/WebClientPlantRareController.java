package com.green.webclientPlant.plantrare;

import com.green.webclientPlant.common.ResultDto;
import com.green.webclientPlant.plantrare.model.PlantRareEntity;
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
@RequestMapping("api/openapi/plant/rare")
@Slf4j
@Tag(name = "희귀/특산식물API" ,description = "희귀/특산식물 CRUD")
public class WebClientPlantRareController {
    private final WebClientPlantRareService service;

    @GetMapping
    @Operation(summary = "희귀/특산식물조회")
    public ResultDto<List<PlantRareEntity>> getPlant(@ParameterObject @ModelAttribute PlantSatelliteGetReq q){
        List<PlantRareEntity> list = service.getPlant(q);
        log.info(list.toString());
        return ResultDto.<List<PlantRareEntity>>builder().
                status(HttpStatus.OK).
                message(HttpStatus.OK.toString()).
                data(list).
                build();
    }

    @PostMapping
    public ResultDto<Integer> postPlant(@RequestBody PlantSatelliteGetReq q){
        int result = service.insRarePlant(q);
        return ResultDto.<Integer>builder().
                status(HttpStatus.OK).
                message(HttpStatus.OK.toString()).
                data(result).
                build();
    }
}
