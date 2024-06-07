package com.green.webclientPlant.outpatient;

import com.green.webclientPlant.outpatient.model.OutPlantEntity;
import com.green.webclientPlant.outpatient.model.OutPlantGetReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WebClientOutPlantMapper {
    int insOut(OutPlantGetReq p);
    int insOutPlant(List<OutPlantEntity> p);
}
