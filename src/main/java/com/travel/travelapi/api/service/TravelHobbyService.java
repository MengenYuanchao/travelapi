package com.travel.travelapi.api.service;

import com.travel.travelapi.api.entityDo.TravelHobbyDo;

import java.util.List;

public interface TravelHobbyService {

    /**
     * 获取爱好列表
     * @return
     */
    List<TravelHobbyDo> selectHobbyList();

    /**
     * 保存用户爱好
     * @param userId
     * @param hobbyIds
     * @return
     */
    int insertUserHobby(String userId,String[] hobbyIds);
}
