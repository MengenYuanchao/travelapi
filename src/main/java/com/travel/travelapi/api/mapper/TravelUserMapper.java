package com.travel.travelapi.api.mapper;

import com.travel.travelapi.api.entity.TravelUser;
import com.travel.travelapi.api.entityDo.TravelUserDo;
import org.apache.ibatis.annotations.Param;

public interface TravelUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(TravelUser record);

    int insertSelective(TravelUser record);

    TravelUserDo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TravelUser record);

    int updateByPrimaryKey(TravelUser record);

    /**
     * 根据手机号和邮箱查询用户
     * @param mobile
     * @return
     */
    TravelUserDo getTravelUserByMobile(@Param(value = "mobile") String mobile,@Param(value="email") String email);

    /**
     * 用户登录
     * @param travelUserDo
     * @return
     */
    TravelUserDo userLogin(TravelUserDo travelUserDo);
}