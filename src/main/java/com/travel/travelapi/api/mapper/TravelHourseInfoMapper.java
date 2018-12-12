package com.travel.travelapi.api.mapper;

import com.github.pagehelper.Page;
import com.travel.travelapi.api.entity.TravelHourseInfo;
import com.travel.travelapi.api.entity.TravelHourseInfoWithBLOBs;
import com.travel.travelapi.api.entityDo.TravelHourseInfoDo;
import com.travel.travelapi.api.entityDo.TravelHourseInfoWithBLOBsDo;
import org.apache.ibatis.annotations.Param;

public interface TravelHourseInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(TravelHourseInfoWithBLOBs record);

    int insertSelective(TravelHourseInfoWithBLOBs record);

    TravelHourseInfoWithBLOBsDo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TravelHourseInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TravelHourseInfoWithBLOBs record);

    int updateByPrimaryKey(TravelHourseInfo record);

    /**
     *我的心愿单
     * @return
     */
    Page<TravelHourseInfoDo> selectMyFavoriteHourseByPage(@Param("userId") String userId);

    /**
     * 我的房源列表
     * @param userId
     * @param status
     * @return
     */
    Page<TravelHourseInfoDo> selectMyHourseListByPage(@Param("userId") String userId,@Param("status") Integer status);
}