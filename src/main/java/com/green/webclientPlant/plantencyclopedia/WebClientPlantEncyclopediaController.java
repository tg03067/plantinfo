package com.green.webclientPlant.plantencyclopedia;

import com.green.webclientPlant.common.ResultDto;
import com.green.webclientPlant.plantencyclopedia.model.PlantEncyclopediaEntity;
import com.green.webclientPlant.plantencyclopedia.model.PlantEncyclopediaGetReq;
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
@RequestMapping("api/openapi/plant/encyclopedia")
@Slf4j
@Tag(name = "식물도감API" ,description = "식물도감 CRUD")
public class WebClientPlantEncyclopediaController {
    private final WebClientPlantEncyclopediaService service;

    @GetMapping
    @Operation(summary = "식물도감조회")
    public ResultDto<List<PlantEncyclopediaEntity>> getPlant(@ParameterObject @ModelAttribute PlantEncyclopediaGetReq q){
        List<PlantEncyclopediaEntity> list = service.getPlant(q);
        log.info(list.toString());
        return ResultDto.<List<PlantEncyclopediaEntity>>builder().
                status(HttpStatus.OK).
                message(HttpStatus.OK.toString()).
                data(list).
                build();
    }

    @PostMapping
    public ResultDto<Integer> postPlant(@RequestBody PlantEncyclopediaGetReq q){
        int result = service.insTest(q);
        return ResultDto.<Integer>builder().
                status(HttpStatus.OK).
                message(HttpStatus.OK.toString()).
                data(result).
                build();
    }
}
