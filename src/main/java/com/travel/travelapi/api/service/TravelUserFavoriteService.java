package com.travel.travelapi.api.service;

import com.travel.travelapi.api.entity.TravelUserFavorite;

public interface TravelUserFavoriteService {

    /**
     * 保存心愿单
     * @param travelUserFavorite
     * @return
     */
    int insert(TravelUserFavorite travelUserFavorite);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(String id);

}
