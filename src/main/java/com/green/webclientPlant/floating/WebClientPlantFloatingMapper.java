package com.green.webclientPlant.floating;

import com.green.webclientPlant.floating.model.PlantFloatingEntity;
import com.green.webclientPlant.satellite.model.PlantSatelliteGetReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WebClientPlantFloatingMapper {
    int insItem(PlantSatelliteGetReq p);
    int insTestInfo(List<PlantFloatingEntity> p);
}
