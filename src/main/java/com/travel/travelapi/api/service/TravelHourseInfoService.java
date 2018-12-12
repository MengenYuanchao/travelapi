package com.travel.travelapi.api.service;

import com.github.pagehelper.Page;
import com.travel.travelapi.api.entity.TravelHourseInfo;
import com.travel.travelapi.api.entity.TravelHourseInfoWithBLOBs;
import com.travel.travelapi.api.entityDo.TravelHourseCalendarPriceDo;
import com.travel.travelapi.api.entityDo.TravelHourseInfoDo;
import com.travel.travelapi.api.entityDo.TravelHourseInfoWithBLOBsDo;

import java.util.List;

public interface TravelHourseInfoService {

    /**
     * 我的心愿单
     * @param pageNo 页号
     * @param pageSize 每页显示记录数
     * @return
     */
    Page<TravelHourseInfoDo> selectMyFavoriteHourseByPage(String userId, int pageNo, int pageSize);

    /**
     * 我的房源列表
     * @param userId
     * @param status
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<TravelHourseInfoDo> selectMyHourseListByPage(String userId,int status,int pageNo,int pageSize);

    /**
     * 保存房屋信息
     * @param record
     * @return
     */
    int insert(TravelHourseInfoWithBLOBs record);

    /**
     * 保存有值的房屋信息
     * @param record
     * @return
     */
    int insertSelective(TravelHourseInfoWithBLOBs record);

    /**
     * 根据房屋ID获取房屋信息
     * @param id
     * @return
     */
    TravelHourseInfoWithBLOBsDo selectByPrimaryKey(String id);

    /**
     * 更新房屋信息（有值）
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(TravelHourseInfoWithBLOBs record);

    /**
     * 更新房屋信息（富文本）
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(TravelHourseInfoWithBLOBs record);

    /**
     * 更新房屋基础信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(TravelHourseInfo record);

    /**
     * 删除房屋信息
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 根据房屋ID和年月查询该月房屋租售信息
     * @param date
     * @param hourseId
     * @return
     */
    List<TravelHourseCalendarPriceDo> selectCalendarList(String date, String hourseId);

}
