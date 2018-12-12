package com.travel.travelapi.api.mapper;

import com.travel.travelapi.api.entity.TravelHourseImg;

public interface TravelHourseImgMapper {
    int deleteByPrimaryKey(String id);

    int insert(TravelHourseImg record);

    int insertSelective(TravelHourseImg record);

    TravelHourseImg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TravelHourseImg record);

    int updateByPrimaryKey(TravelHourseImg record);
}