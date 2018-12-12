package com.travel.travelapi.api.service;

import com.travel.travelapi.api.entityDo.*;

import java.util.List;

public interface TravelSystemService {
    /**
     * 获取国家列表
     * @return
     */
    List<AreaCountryDo> getAreaCountryList();

    /**
     * 获取省份列表
     * @return
     */
    List<AreaProvinceDo> getAreaProvinceList(String countryId);

    /**
     * 获取城市列表
     * @return
     */
    List<AreaCityDo> getAreaCityList(String provinceId);

    /**
     * 获取区县列表
     * @return
     */
    List<AreaCountyDo> getAreaCountyList(String cityId);

    /**
     * 获取房屋类型列表
     * @return
     */
    List<TravelHourseTypeDo> selectHourseTypeList();

    /**
     * 根据房屋类型ID获取房屋详细列表
     * @param hourseTypeId
     * @return
     */
    List<TravelHourseTypeDetailDo> selectHourseTypeDetailList(String hourseTypeId);
}
