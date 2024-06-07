package com.green.webclientPlant.outpatient;

import com.green.webclientPlant.common.ResultDto;
import com.green.webclientPlant.outpatient.model.OutPlantGetReq;
import com.green.webclientPlant.outpatient.model.OutPlantEntity;
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
@RequestMapping("api/openapi/plant/out")
@Slf4j
@Tag(name = "외래식물관련API" ,description = "외래식물 CRUD")
public class WebClientOutPlantController {
    private final WebClientOutPlantService service;

    @GetMapping
    @Operation(summary = "외래식물정보조회")
    public ResultDto<List<OutPlantEntity>> getPlant(@ParameterObject @ModelAttribute OutPlantGetReq q){
        List<OutPlantEntity> list = service.getPlant(q);
        log.info(list.toString());
        return ResultDto.<List<OutPlantEntity>>builder().
                status(HttpStatus.OK).
                message(HttpStatus.OK.toString()).
                data(list).
                build();
    }

    @PostMapping
    @Operation(summary = "외래식물정보 등록")
    public ResultDto<Integer> postPlant(@RequestBody OutPlantGetReq q){
        int result = service.insOutPlant(q);
        return ResultDto.<Integer>builder().
                status(HttpStatus.OK).
                message(HttpStatus.OK.toString()).
                data(result).
                build();
    }
}