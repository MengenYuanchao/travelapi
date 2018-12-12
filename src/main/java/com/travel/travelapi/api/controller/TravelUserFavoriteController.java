package com.travel.travelapi.api.controller;


import com.github.pagehelper.Page;
import com.travel.travelapi.api.entity.TravelUser;
import com.travel.travelapi.api.entity.TravelUserFavorite;
import com.travel.travelapi.api.entityDo.TravelHourseInfoDo;
import com.travel.travelapi.api.entityDo.TravelUserDo;
import com.travel.travelapi.api.service.EmailService;
import com.travel.travelapi.api.service.TravelHourseInfoService;
import com.travel.travelapi.api.service.TravelUserFavoriteService;
import com.travel.travelapi.api.service.TravelUserService;
import com.travel.travelapi.base.PageBean;
import com.travel.travelapi.base.ResultMsg;
import com.travel.travelapi.enumUtils.ResultEnum;
import com.travel.travelapi.utils.JobConstUtils;
import com.travel.travelapi.utils.RandomUtil;
import com.travel.travelapi.utils.SecurityUtils;
import io.swagger.annotations.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/travelUserFavorite")
@Api(value = "心愿单",description = "心愿单")
public class TravelUserFavoriteController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TravelUserFavoriteService travelUserFavoriteService;
    @Autowired
    private TravelHourseInfoService travelHourseInfoService;


    @ApiOperation(value="我的心愿单", notes="我的心愿单" )
    @ResponseBody
    @GetMapping("/index")
    public ResultMsg<PageBean<TravelHourseInfoDo>> index(@ApiParam(value="当前页") @RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                                @ApiParam(value="每页条数") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                @ApiParam(value="用户ID") @RequestParam(value = "userId", required = true) String userId){
        logger.info("进入我的心愿单：用户ID：{}",userId);
        ResultMsg resultMsg=new ResultMsg();
        try{

            Page<TravelHourseInfoDo> hourseInfos = travelHourseInfoService.selectMyFavoriteHourseByPage(userId,pageNo,pageSize);
            PageBean<TravelHourseInfoDo> hourseInfoDoPageBean =new PageBean<TravelHourseInfoDo>();
            BeanUtils.copyProperties(hourseInfoDoPageBean, hourseInfos);
            hourseInfoDoPageBean.setItems(hourseInfos);
            resultMsg.setData(hourseInfoDoPageBean);


        }catch (Exception e){
            e.printStackTrace();
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("心愿单获取失败");
            logger.info("获取心愿单失败信息：{1}",e.getMessage());
        }
        return resultMsg;
    }

    @ApiOperation(value="添加心愿单", notes="添加心愿单" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID",  paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "hourseInfoId", value = "房屋ID",  paramType = "query", required = true, dataType = "String")})
    @ResponseBody
    @PostMapping("/insertUserFavorite")
    public ResultMsg insertUserFavorite(@RequestParam(value = "userId", required = true) String userId,
                                        @RequestParam(value = "hourseInfoId", required = true) String hourseInfoId){
        logger.info("添加心愿单请求信息：用户ID：{}；房屋ID：{}",userId,hourseInfoId);
        ResultMsg resultMsg=new ResultMsg();
        try{
            TravelUserFavorite travelUserFavorite =new TravelUserFavorite();
            travelUserFavorite.setId(RandomUtil.getUuid());
            travelUserFavorite.setCreateTime(new Date());
            travelUserFavoriteService.insert(travelUserFavorite);
            resultMsg.setMsg("已添加");
        }catch (Exception e){
            e.printStackTrace();
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("添加失败");
            logger.info("添加心愿单失败，失败信息：{}",e.getMessage());
        }
        return resultMsg;
    }

    @ApiOperation(value="删除心愿单", notes="删除心愿单" )
    @ResponseBody
    @DeleteMapping("/deleteUserFavorite/{favoriteId}")
    public ResultMsg deleteUserFavorite(@ApiParam(value = "心愿单ID") @PathVariable(value = "favoriteId", required = true) String favoriteId){
        logger.info("删除心愿单请求信息：心愿单ID：{}",favoriteId);
        ResultMsg resultMsg=new ResultMsg();
        try{

            travelUserFavoriteService.delete(favoriteId);
            resultMsg.setMsg("已取消");
        }catch (Exception e){
            e.printStackTrace();
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("取消失败");
            logger.info("取消心愿单失败，失败信息：{}",e.getMessage());
        }
        return resultMsg;
    }
}
