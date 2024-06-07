package com.green.webclientPlant.plantencyclopedia;

import com.green.webclientPlant.plantencyclopedia.model.PlantEncyclopediaEntity;
import com.green.webclientPlant.plantencyclopedia.model.PlantEncyclopediaGetReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WebClientPlantEncyclopediaMapper {
    int insItem(PlantEncyclopediaGetReq p);
    int insPlantEncyclopedia(List<PlantEncyclopediaEntity> p);
}
