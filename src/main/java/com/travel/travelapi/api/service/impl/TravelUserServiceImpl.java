package com.travel.travelapi.api.service.impl;

import com.travel.travelapi.api.entity.TravelUser;
import com.travel.travelapi.api.entityDo.TravelUserDo;
import com.travel.travelapi.api.mapper.TravelUserMapper;
import com.travel.travelapi.api.service.TravelUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelUserServiceImpl implements TravelUserService {
    @Autowired
    private TravelUserMapper travelUserMapper;

    /**
     * 跟新用户信息
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(TravelUser record) {
        return travelUserMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据手机号查询用户
     *
     * @param mobile
     * @return
     */
    @Override
    public TravelUserDo getTravelUserByMobile(String mobile,String email) {
        return travelUserMapper.getTravelUserByMobile(mobile,email);
    }

    /**
     * 保存用户
     *
     * @param record
     * @return
     */
    @Override
    public int insert(TravelUser record) {
        return travelUserMapper.insert(record);
    }

    /**
     * 用户登录
     *
     * @param travelUserDo
     * @return
     */
    @Override
    public TravelUserDo userLogin(TravelUserDo travelUserDo) {
        return travelUserMapper.userLogin(travelUserDo);
    }

    /**
     * 根据用户ID获取用户信息
     *
     * @param id
     * @return
     */
    @Override
    public TravelUserDo selectByPrimaryKey(String id) {
        return travelUserMapper.selectByPrimaryKey(id);
    }
}
