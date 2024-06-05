package com.green.webclientPlant.plantrare;

import com.green.webclientPlant.plantrare.model.PlantRareEntity;
import com.green.webclientPlant.satellite.model.PlantSatelliteGetReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WebClientPlantRareMapper {
    int insItem(PlantSatelliteGetReq p);
    int insTestInfo(List<PlantRareEntity> p);
}
