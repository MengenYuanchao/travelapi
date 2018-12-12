package com.travel.travelapi.api.mapper;

import com.travel.travelapi.api.entity.TravelBanner;
import com.travel.travelapi.api.entityDo.TravelBannerDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TravelBannerMapper {
    int deleteByPrimaryKey(String id);

    int insert(TravelBanner record);

    int insertSelective(TravelBanner record);

    TravelBanner selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TravelBanner record);

    int updateByPrimaryKey(TravelBanner record);

    /**
     * 根据类型获取banner列表
     * @param type
     * @return
     */
    List<TravelBannerDo> selectBannerListByType(@Param("type") int type);
}