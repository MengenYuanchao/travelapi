package com.travel.travelapi.api.mapper;

import com.travel.travelapi.api.entity.TravelHoppy;
import com.travel.travelapi.api.entityDo.TravelHobbyDo;

import java.util.List;

public interface TravelHoppyMapper {
    int deleteByPrimaryKey(String id);

    int insert(TravelHoppy record);

    int insertSelective(TravelHoppy record);

    TravelHoppy selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TravelHoppy record);

    int updateByPrimaryKey(TravelHoppy record);

    /**
     * 获取爱好列表
     * @return
     */
    List<TravelHobbyDo> selectHobbyList();
}