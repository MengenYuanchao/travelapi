package com.travel.travelapi.api.controller;


import com.github.pagehelper.Page;
import com.travel.travelapi.api.entity.TravelHourseInfoWithBLOBs;
import com.travel.travelapi.api.entity.TravelUserFavorite;
import com.travel.travelapi.api.entityDo.TravelHourseCalendarPriceDo;
import com.travel.travelapi.api.entityDo.TravelHourseInfoDo;
import com.travel.travelapi.api.entityDo.TravelHourseInfoWithBLOBsDo;
import com.travel.travelapi.api.service.TravelHourseInfoService;
import com.travel.travelapi.api.service.TravelUserFavoriteService;
import com.travel.travelapi.base.PageBean;
import com.travel.travelapi.base.ResultMsg;
import com.travel.travelapi.enumUtils.ResultEnum;
import com.travel.travelapi.utils.RandomUtil;
import io.swagger.annotations.*;
import io.swagger.models.auth.In;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/travelUserHourse")
@Api(value = "我的房源",description = "我的房源")
public class TravelUserHourseController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TravelHourseInfoService travelHourseInfoService;


    @ApiOperation(value="我的房源列表", notes="我的房源列表" )
    @ResponseBody
    @GetMapping("/index")
    public ResultMsg<PageBean<TravelHourseInfoDo>> index(@ApiParam(value="当前页")
                                                             @RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                                                         @ApiParam(value="每页条数")
                                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                         @ApiParam(value="用户ID")
                                                             @RequestParam(value = "userId", required = true) String userId,
                                                         @ApiParam(value="状态，0未审核通过，1审核通过，2全部")
                                                             @RequestParam(value = "status", required = true,defaultValue = "2") Integer status){
        logger.info("进入我的房源列表：用户ID：{}，类型：{}",userId,status);
        ResultMsg resultMsg=new ResultMsg();
        try{

            Page<TravelHourseInfoDo> hourseInfos = travelHourseInfoService.selectMyHourseListByPage(userId,status,pageNo,pageSize);
            PageBean<TravelHourseInfoDo> hourseInfoDoPageBean =new PageBean<TravelHourseInfoDo>();
            BeanUtils.copyProperties(hourseInfoDoPageBean, hourseInfos);
            hourseInfoDoPageBean.setItems(hourseInfos.getResult());
            resultMsg.setData(hourseInfoDoPageBean);

            logger.info(resultMsg.toString());
        }catch (Exception e){
            e.printStackTrace();
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("房源列表获取失败");
            logger.info("获取房源列表失败信息：{1}",e.getMessage());
        }
        return resultMsg;
    }

    @ApiOperation(value="添加房屋", notes="添加房屋" )
    @ResponseBody
    @PostMapping("/insertUserHourse")
    public ResultMsg insertUserHourse(@ApiParam(value = "房屋信息")
                                            @RequestBody TravelHourseInfoWithBLOBsDo hourseInfo){
        logger.info("添加房屋请求信息：{}",hourseInfo.toString());
        ResultMsg resultMsg=new ResultMsg();
        try{
            TravelHourseInfoWithBLOBs travelHourseInfoWithBLOBs = new TravelHourseInfoWithBLOBs();
            hourseInfo.setId(RandomUtil.getUuid());
            BeanUtils.copyProperties(travelHourseInfoWithBLOBs, hourseInfo);
            travelHourseInfoService.insert(travelHourseInfoWithBLOBs);
            resultMsg.setMsg("已添加");
        }catch (Exception e){
            e.printStackTrace();
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("添加失败");
            logger.info("添加房屋信息失败，失败信息：{}",e.getMessage());
        }
        return resultMsg;
    }
    @ApiOperation(value="修改房屋", notes="修改房屋" )
    @ResponseBody
    @PutMapping("/updateUserHourse")
    public ResultMsg updateUserHourse(@ApiParam(value = "房屋信息")
                                      @RequestBody TravelHourseInfoWithBLOBsDo hourseInfo){
        logger.info("修改房屋请求信息：{}",hourseInfo.toString());
        ResultMsg resultMsg=new ResultMsg();
        try{
            TravelHourseInfoWithBLOBs travelHourseInfoWithBLOBs = new TravelHourseInfoWithBLOBs();
            BeanUtils.copyProperties(travelHourseInfoWithBLOBs, hourseInfo);
            travelHourseInfoService.updateByPrimaryKeySelective(travelHourseInfoWithBLOBs);
            resultMsg.setMsg("已修改");
        }catch (Exception e){
            e.printStackTrace();
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("修改失败");
            logger.info("修改房屋信息失败，失败信息：{}",e.getMessage());
        }
        return resultMsg;
    }
    @ApiOperation(value="删除房屋信息", notes="删除修改房屋" )
    @ResponseBody
    @DeleteMapping("/deleteUserHourse/{hourseId}")
    public ResultMsg deleteUserHourse(@ApiParam(value = "房屋ID")
                                      @PathVariable("hourseId") String hourseId){
        logger.info("删除房屋请求信息：{}",hourseId);
        ResultMsg resultMsg=new ResultMsg();
        try{

            travelHourseInfoService.deleteByPrimaryKey(hourseId);
            resultMsg.setMsg("已修改");
        }catch (Exception e){
            e.printStackTrace();
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("修改失败");
            logger.info("修改房屋信息失败，失败信息：{}",e.getMessage());
        }
        return resultMsg;
    }

    @ApiOperation(value="日历查询", notes="日历查询" )
    @ResponseBody
    @GetMapping("/getUsableCalendarByHourseId")
    public ResultMsg<TravelHourseCalendarPriceDo> getUsableCalendarByHourseId(
                                                         @ApiParam(value="日期（yyyy-MM-dd）")
                                                         @RequestParam(value = "date", required = true) String date,
                                                         @ApiParam(value="用户ID")
                                                         @RequestParam(value = "userId", required = true) String userId,
                                                         @ApiParam(value="房屋ID")
                                                         @RequestParam(value = "hourseId", required = true) String hourseId){
        logger.info("根据房屋ID和日期查询日历：用户ID：{}，日期：{}，房屋ID：{}",userId,date,hourseId);
        ResultMsg resultMsg=new ResultMsg();
        try{

            List<TravelHourseCalendarPriceDo> calendarPriceDoList = travelHourseInfoService.selectCalendarList(date,hourseId);
            resultMsg.setData(calendarPriceDoList);
            logger.info(resultMsg.toString());
        }catch (Exception e){
            e.printStackTrace();
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("获取失败");
            logger.info("根据房屋ID和日期查询日历失败信息：{1}",e.getMessage());
        }
        return resultMsg;
    }

    @ApiOperation(value="设置日历", notes="设置日历" )
    @ResponseBody
    @PutMapping("/updateCalendarByHourseId")
    public ResultMsg updateCalendarByHourseId(
            @ApiParam(value="设置日历集合")
            @RequestBody List<TravelHourseCalendarPriceDo> list){
        logger.info("设置日历：{}",list.toArray().toString());
        ResultMsg resultMsg=new ResultMsg();
        try{

            /*List<TravelHourseCalendarPriceDo> calendarPriceDoList = travelHourseInfoService.selectCalendarList(date,hourseId);
            resultMsg.setData(calendarPriceDoList);*/
            logger.info(resultMsg.toString());
        }catch (Exception e){
            e.printStackTrace();
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("设置失败");
            logger.info("设置日历失败信息：{1}",e.getMessage());
        }
        return resultMsg;
    }

}
