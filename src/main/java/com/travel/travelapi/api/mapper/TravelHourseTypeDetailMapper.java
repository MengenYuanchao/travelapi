package com.travel.travelapi.api.mapper;

import com.travel.travelapi.api.entity.TravelHourseTypeDetail;
import com.travel.travelapi.api.entityDo.TravelHourseTypeDetailDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TravelHourseTypeDetailMapper {
    int deleteByPrimaryKey(String id);

    int insert(TravelHourseTypeDetail record);

    int insertSelective(TravelHourseTypeDetail record);

    TravelHourseTypeDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TravelHourseTypeDetail record);

    int updateByPrimaryKey(TravelHourseTypeDetail record);

    List<TravelHourseTypeDetailDo> selectHourseTypeDetailList(@Param("hourseTypeId") String hourseTypeId);
}