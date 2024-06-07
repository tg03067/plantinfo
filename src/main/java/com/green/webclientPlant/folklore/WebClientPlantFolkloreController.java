package com.green.webclientPlant.folklore;

import com.green.webclientPlant.common.ResultDto;
import com.green.webclientPlant.folklore.model.PlantFolkloreEntity;
import com.green.webclientPlant.folklore.model.PlantFolkloreGetReq;
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
@RequestMapping("api/openapi/plant/Folklore")
@Slf4j
@Tag(name = "민속식물API" ,description = "민속식물 CRUD")
public class WebClientPlantFolkloreController {
    private final WebClientPlantFolkloreService service;

    @GetMapping
    @Operation(summary = "민속식물조회")
    public ResultDto<List<PlantFolkloreEntity>> getPlant(@ParameterObject @ModelAttribute PlantFolkloreGetReq q){
        List<PlantFolkloreEntity> list = service.getPlant(q);
        log.info(list.toString());
        return ResultDto.<List<PlantFolkloreEntity>>builder().
                status(HttpStatus.OK).
                message(HttpStatus.OK.toString()).
                data(list).
                build();
    }

    @PostMapping
    @Operation(summary = "민속식물정보 등록")
    public ResultDto<Integer> postPlant(@RequestBody PlantFolkloreGetReq q){
        int result = service.insFolklorePlant(q);
        return ResultDto.<Integer>builder().
                status(HttpStatus.OK).
                message(HttpStatus.OK.toString()).
                data(result).
                build();
    }
}
