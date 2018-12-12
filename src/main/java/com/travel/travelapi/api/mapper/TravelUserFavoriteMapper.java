package com.travel.travelapi.api.mapper;

import com.travel.travelapi.api.entity.TravelUserFavorite;

public interface TravelUserFavoriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(TravelUserFavorite record);

    int insertSelective(TravelUserFavorite record);

    TravelUserFavorite selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TravelUserFavorite record);

    int updateByPrimaryKey(TravelUserFavorite record);
}