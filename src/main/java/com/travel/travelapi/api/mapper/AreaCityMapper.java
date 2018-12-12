package com.travel.travelapi.api.mapper;

import com.travel.travelapi.api.entity.AreaCity;
import com.travel.travelapi.api.entityDo.AreaCityDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaCityMapper {
    int deleteByPrimaryKey(String id);

    int insert(AreaCity record);

    int insertSelective(AreaCity record);

    AreaCity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AreaCity record);

    int updateByPrimaryKey(AreaCity record);

    /**
     * 获取城市列表
     * @return
     */
    List<AreaCityDo> getAreaCityList(@Param("provinceId") String provinceId);

}