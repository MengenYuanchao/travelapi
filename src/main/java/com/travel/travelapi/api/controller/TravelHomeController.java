package com.travel.travelapi.api.controller;

import com.github.pagehelper.Page;
import com.travel.travelapi.api.entity.TravelHourseInfo;
import com.travel.travelapi.api.entityDo.TravelBannerDo;
import com.travel.travelapi.api.entityDo.TravelHobbyDo;
import com.travel.travelapi.api.service.TravelBannerService;
import com.travel.travelapi.api.service.TravelHobbyService;
import com.travel.travelapi.api.service.TravelHourseInfoService;
import com.travel.travelapi.base.ResultMsg;
import com.travel.travelapi.enumUtils.ResultEnum;
import com.travel.travelapi.utils.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/travelHome")
@Api(value = "首页信息",description = "首页信息")
public class TravelHomeController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TravelBannerService travelBannerService;

    @Autowired
    private TravelHourseInfoService travelHourseInfoService;



    @ApiOperation(value="用户首页信息", notes="用户首页信息" )
    @ResponseBody
    @PostMapping("/index")
    @ApiImplicitParam(name = "type", value = "banner类型，1banner图，2心愿单", paramType = "query", required = true, dataType = "Integer")
    public ResultMsg<Map> index(@RequestParam(value = "type", required = true) Integer type){
        logger.info("进入首页信息：{}",type);
        ResultMsg resultMsg=new ResultMsg();
        try{
            Map resultMap=new HashMap();
            List<TravelBannerDo> bannerDoList = travelBannerService.selectBannerListByType(type);

            resultMap.put("bannerList",bannerDoList);
            resultMsg.setData(resultMap);


        }catch (Exception e){
            e.printStackTrace();
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("获取首页信息失败");
            logger.info("获取首页信息：{1}",e.getMessage());
        }
        return resultMsg;
    }


}
