package com.travel.travelapi.api.service.impl;

import com.travel.travelapi.api.entity.TravelUserFavorite;
import com.travel.travelapi.api.mapper.TravelUserFavoriteMapper;
import com.travel.travelapi.api.service.TravelUserFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelUserFavoriteServiceImpl implements TravelUserFavoriteService {

    @Autowired
    private TravelUserFavoriteMapper travelUserFavoriteMapper;

    /**
     * 保存心愿单
     *
     * @param travelUserFavorite
     * @return
     */
    @Override
    public int insert(TravelUserFavorite travelUserFavorite) {
        return travelUserFavoriteMapper.insert(travelUserFavorite);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public int delete(String id) {
        return travelUserFavoriteMapper.deleteByPrimaryKey(id);
    }
}
