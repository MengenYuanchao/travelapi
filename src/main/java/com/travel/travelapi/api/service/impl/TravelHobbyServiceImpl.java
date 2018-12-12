package com.travel.travelapi.api.service.impl;

import com.travel.travelapi.api.entity.TravelUserHobby;
import com.travel.travelapi.api.entityDo.TravelHobbyDo;
import com.travel.travelapi.api.mapper.TravelHoppyMapper;
import com.travel.travelapi.api.mapper.TravelUserHobbyMapper;
import com.travel.travelapi.api.service.TravelHobbyService;
import com.travel.travelapi.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelHobbyServiceImpl implements TravelHobbyService {


    @Autowired
    private TravelHoppyMapper travelHoppyMapper;
    @Autowired
    private TravelUserHobbyMapper travelUserHobbyMapper;

    /**
     * 获取爱好列表
     *
     * @return
     */
    @Override
    public List<TravelHobbyDo> selectHobbyList() {
        return travelHoppyMapper.selectHobbyList();
    }

    /**
     * 保存用户爱好
     *
     * @param userId
     * @param hobbyIds
     * @return
     */
    @Override
    public int insertUserHobby(String userId, String[] hobbyIds) {
        travelUserHobbyMapper.deleteByUserId(userId);
        TravelUserHobby travelUserHobby =null;
        for (int i=0;i<hobbyIds.length;i++) {
            travelUserHobby = new TravelUserHobby();
            travelUserHobby.setHobbyId(hobbyIds[i]);
            travelUserHobby.setUserId(userId);
            travelUserHobby.setId(RandomUtil.getUuid());
            travelUserHobbyMapper.insert(travelUserHobby);
        }
        return 0;
    }
}
