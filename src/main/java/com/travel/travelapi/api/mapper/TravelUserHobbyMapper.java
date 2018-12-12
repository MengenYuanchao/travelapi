package com.travel.travelapi.api.mapper;

import com.travel.travelapi.api.entity.TravelUserHobby;
import org.apache.ibatis.annotations.Param;

public interface TravelUserHobbyMapper {
    int deleteByPrimaryKey(String id);

    int insert(TravelUserHobby record);

    int insertSelective(TravelUserHobby record);

    TravelUserHobby selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TravelUserHobby record);

    int updateByPrimaryKey(TravelUserHobby record);

    /**
     * 根据用户ID删除用户爱好
     * @param userId
     * @return
     */
    int deleteByUserId(@Param("userId") String userId);
}