package com.travel.travelapi.api.service.impl;

import com.travel.travelapi.api.entityDo.*;
import com.travel.travelapi.api.mapper.*;
import com.travel.travelapi.api.service.TravelSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelSystemServiceImpl implements TravelSystemService {
    @Autowired
    private AreaProvinceMapper areaProvinceMapper;
    @Autowired
    private AreaCityMapper areaCityMapper;
    @Autowired
    private AreaCountyMapper areaCountyMapper;
    @Autowired
    private AreaCountryMapper areaCountryMapper;
    @Autowired
    private TravelHourseTypeMapper travelHourseTypeMapper;
    @Autowired
    private TravelHourseTypeDetailMapper travelHourseTypeDetailMapper;

    /**
     * 获取国家列表
     *
     * @return
     */
    @Override
    public List<AreaCountryDo> getAreaCountryList() {
        return areaCountryMapper.getAreaCountryList();
    }

    /**
     * 获取省份列表
     *
     * @return
     */
    @Override
    public List<AreaProvinceDo> getAreaProvinceList(String countryId) {
        return areaProvinceMapper.getAreaProvinceList(countryId);
    }

    /**
     * 获取城市列表
     *
     * @return
     */
    @Override
    public List<AreaCityDo> getAreaCityList(String provinceId) {
        return areaCityMapper.getAreaCityList(provinceId);
    }

    /**
     * 获取区县列表
     *
     * @return
     */
    @Override
    public List<AreaCountyDo> getAreaCountyList(String cityId) {
        return areaCountyMapper.getAreaCountyList(cityId);
    }

    /**
     * 获取房屋类型列表
     *
     * @return
     */
    @Override
    public List<TravelHourseTypeDo> selectHourseTypeList() {
        return travelHourseTypeMapper.selectHourseTypeList();
    }

    /**
     * 根据房屋类型ID获取房屋详细列表
     *
     * @param hourseTypeId
     * @return
     */
    @Override
    public List<TravelHourseTypeDetailDo> selectHourseTypeDetailList(String hourseTypeId) {
        return travelHourseTypeDetailMapper.selectHourseTypeDetailList(hourseTypeId);
    }
}
