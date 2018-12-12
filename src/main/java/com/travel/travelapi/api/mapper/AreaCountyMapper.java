package com.travel.travelapi.api.mapper;

import com.travel.travelapi.api.entity.AreaCounty;
import com.travel.travelapi.api.entityDo.AreaCountyDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaCountyMapper {
    int deleteByPrimaryKey(String id);

    int insert(AreaCounty record);

    int insertSelective(AreaCounty record);

    AreaCounty selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AreaCounty record);

    int updateByPrimaryKey(AreaCounty record);

    /**
     * 获取区县列表
     * @return
     */
    List<AreaCountyDo> getAreaCountyList(@Param("cityId") String cityId);
}