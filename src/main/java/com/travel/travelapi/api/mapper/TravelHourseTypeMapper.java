package com.travel.travelapi.api.mapper;

import com.travel.travelapi.api.entity.TravelHourseType;
import com.travel.travelapi.api.entityDo.TravelHourseTypeDo;

import java.util.List;

public interface TravelHourseTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(TravelHourseType record);

    int insertSelective(TravelHourseType record);

    TravelHourseType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TravelHourseType record);

    int updateByPrimaryKey(TravelHourseType record);

    List<TravelHourseTypeDo> selectHourseTypeList();
}