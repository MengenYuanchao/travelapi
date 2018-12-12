package com.travel.travelapi.api.service;

import com.travel.travelapi.api.entityDo.TravelBannerDo;

import java.util.List;

public interface TravelBannerService {
    /**
     * 根据类型获取banner列表
     * @param type
     * @return
     */
    List<TravelBannerDo> selectBannerListByType(int type);
}
