package com.travel.travelapi.api.mapper;

import com.travel.travelapi.api.entity.TravelHourseCalendarPrice;
import com.travel.travelapi.api.entityDo.TravelHourseCalendarPriceDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TravelHourseCalendarPriceMapper {
    int deleteByPrimaryKey(String id);

    int insert(TravelHourseCalendarPrice record);

    int insertSelective(TravelHourseCalendarPrice record);

    TravelHourseCalendarPrice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TravelHourseCalendarPrice record);

    int updateByPrimaryKey(TravelHourseCalendarPrice record);

    /**
     * 根据房屋ID和年月查询该月房屋租售信息
     * @param date
     * @param hourseId
     * @return
     */
    List<TravelHourseCalendarPriceDo> selectCalendarList(@Param("date") String date,@Param("hourseId") String hourseId);
}