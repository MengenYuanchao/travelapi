package com.travel.travelapi.api.service.impl;

import com.travel.travelapi.api.entityDo.TravelBannerDo;
import com.travel.travelapi.api.mapper.TravelBannerMapper;
import com.travel.travelapi.api.service.TravelBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelBannerServiceImpl implements TravelBannerService {

    @Autowired
    private TravelBannerMapper travelBannerMapper;

    /**
     * 根据类型获取banner列表
     *
     * @param type
     * @return
     */
    @Override
    public List<TravelBannerDo> selectBannerListByType(int type) {
        return travelBannerMapper.selectBannerListByType(type);
    }
}
