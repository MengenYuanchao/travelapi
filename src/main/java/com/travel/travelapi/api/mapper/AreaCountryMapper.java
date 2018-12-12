package com.travel.travelapi.api.mapper;

import com.travel.travelapi.api.entity.AreaCountry;
import com.travel.travelapi.api.entityDo.AreaCountryDo;

import java.util.List;

public interface AreaCountryMapper {
    int deleteByPrimaryKey(String id);

    int insert(AreaCountry record);

    int insertSelective(AreaCountry record);

    AreaCountry selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AreaCountry record);

    int updateByPrimaryKey(AreaCountry record);
    /**
     * 获取国家列表
     * @return
     */
    List<AreaCountryDo> getAreaCountryList();


}