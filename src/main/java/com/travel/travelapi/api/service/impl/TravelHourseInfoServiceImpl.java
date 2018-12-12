package com.travel.travelapi.api.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.travel.travelapi.api.entity.TravelHourseInfo;
import com.travel.travelapi.api.entity.TravelHourseInfoWithBLOBs;
import com.travel.travelapi.api.entityDo.TravelHourseCalendarPriceDo;
import com.travel.travelapi.api.entityDo.TravelHourseInfoDo;
import com.travel.travelapi.api.entityDo.TravelHourseInfoWithBLOBsDo;
import com.travel.travelapi.api.mapper.TravelHourseCalendarPriceMapper;
import com.travel.travelapi.api.mapper.TravelHourseInfoMapper;
import com.travel.travelapi.api.service.TravelHourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelHourseInfoServiceImpl implements TravelHourseInfoService {

    @Autowired
    private TravelHourseInfoMapper travelHourseInfoMapper;
    @Autowired
    private TravelHourseCalendarPriceMapper travelHourseCalendarPriceMapper;

    /**
     * 我的心愿单
     *
     * @param pageNo   页号
     * @param pageSize 每页显示记录数
     * @return
     */
    @Override
    public Page<TravelHourseInfoDo> selectMyFavoriteHourseByPage(String userId, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return travelHourseInfoMapper.selectMyFavoriteHourseByPage(userId);
    }

    /**
     * 我的房源列表
     *
     * @param userId
     * @param status
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public Page<TravelHourseInfoDo> selectMyHourseListByPage(String userId, int status, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return travelHourseInfoMapper.selectMyHourseListByPage(userId,status);
    }

    /**
     * 保存房屋信息
     *
     * @param record
     * @return
     */
    @Override
    public int insert(TravelHourseInfoWithBLOBs record) {
        return travelHourseInfoMapper.insert(record);
    }

    /**
     * 保存有值的房屋信息
     *
     * @param record
     * @return
     */
    @Override
    public int insertSelective(TravelHourseInfoWithBLOBs record) {
        return travelHourseInfoMapper.insertSelective(record);
    }

    /**
     * 根据房屋ID获取房屋信息
     *
     * @param id
     * @return
     */
    @Override
    public TravelHourseInfoWithBLOBsDo selectByPrimaryKey(String id) {
        return travelHourseInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新房屋信息（有值）
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(TravelHourseInfoWithBLOBs record) {
        return travelHourseInfoMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 更新房屋信息（富文本）
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeyWithBLOBs(TravelHourseInfoWithBLOBs record) {
        return travelHourseInfoMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    /**
     * 更新房屋基础信息
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(TravelHourseInfo record) {
        return travelHourseInfoMapper.updateByPrimaryKey(record);
    }

    /**
     * 删除房屋信息
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(String id) {
        return travelHourseInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据房屋ID和年月查询该月房屋租售信息
     *
     * @param date
     * @param hourseId
     * @return
     */
    @Override
    public List<TravelHourseCalendarPriceDo> selectCalendarList(String date, String hourseId) {
        return travelHourseCalendarPriceMapper.selectCalendarList(date, hourseId);
    }
}
