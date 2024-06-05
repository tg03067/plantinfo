package com.green.webclientPlant.satellite;

import com.green.webclientPlant.satellite.model.PlantSatelliteEntity;
import com.green.webclientPlant.satellite.model.PlantSatelliteGetReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WebClientPlantSatelliteMapper {
    int insItem(PlantSatelliteGetReq p);
    int insTestInfo(List<PlantSatelliteEntity> p);
}
