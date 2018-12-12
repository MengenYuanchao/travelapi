package com.travel.travelapi.api.mapper;

import com.travel.travelapi.api.entity.AreaProvince;
import com.travel.travelapi.api.entityDo.AreaProvinceDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaProvinceMapper {
    int deleteByPrimaryKey(String id);

    int insert(AreaProvince record);

    int insertSelective(AreaProvince record);

    AreaProvince selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AreaProvince record);

    int updateByPrimaryKey(AreaProvince record);


    /**
     * 获取省份列表
     * @return
     */
    List<AreaProvinceDo> getAreaProvinceList(@Param("countryId") String countryId);

}