package com.travel.travelapi.api.service;

import com.travel.travelapi.api.entity.TravelUser;
import com.travel.travelapi.api.entityDo.TravelUserDo;

public interface TravelUserService {

    /**
     * 根据手机号查询用户
     * @param mobile
     * @return
     */
    TravelUserDo getTravelUserByMobile(String mobile,String email);

    /**
     * 跟新用户信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(TravelUser record);

    /**
     * 保存用户
     * @param record
     * @return
     */
    int insert(TravelUser record);

    /**
     * 用户登录
     * @param travelUserDo
     * @return
     */
    TravelUserDo userLogin(TravelUserDo travelUserDo);

    /**
     * 根据用户ID获取用户信息
     * @param id
     * @return
     */
    TravelUserDo selectByPrimaryKey(String id);
}
