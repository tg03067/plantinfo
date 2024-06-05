package com.green.webclientPlant.folklore;

import com.green.webclientPlant.folklore.model.PlantFolkloreEntity;
import com.green.webclientPlant.folklore.model.PlantFolkloreGetReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WebClientPlantFolkloreMapper {
    int insItem(PlantFolkloreGetReq p);
    int insTestInfo(List<PlantFolkloreEntity> p);
}
