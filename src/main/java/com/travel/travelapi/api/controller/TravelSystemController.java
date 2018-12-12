package com.travel.travelapi.api.controller;

import com.travel.travelapi.api.entityDo.*;
import com.travel.travelapi.api.service.TravelSystemService;
import com.travel.travelapi.base.ResultMsg;
import com.travel.travelapi.enumUtils.ResultEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/travelSystem")
@Api(value = "系统信息",description = "系统信息")
public class TravelSystemController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TravelSystemService travelSystemService;

    @ApiOperation(value="国家列表", notes="国家列表" )
    @ResponseBody
    @GetMapping("/getCountryList")
    public ResultMsg<AreaCountryDo> getCountryList(){
        logger.info("请求国家列表开始");
        ResultMsg resultMsg=new ResultMsg();
        try{
            resultMsg.setData(travelSystemService.getAreaCountryList());
        }catch (Exception e){
            e.printStackTrace();
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("请求国家列表失败");
            logger.info("请求国家列表失败，失败信息：{}",e.getMessage());
        }
        return resultMsg;
    }
    @ApiOperation(value="省份列表", notes="省份列表" )
    @ApiImplicitParam(name = "countryId", value = "国家ID", paramType = "query", required = true, dataType = "String")
    @ResponseBody
    @GetMapping("/getProvinceList")
    public ResultMsg<AreaProvinceDo> getProvinceList(@RequestParam(value = "countryId", required = true) String countryId){
        logger.info("请求省份列表开始，国家ID{}",countryId);
        ResultMsg resultMsg=new ResultMsg();
        try{
            resultMsg.setData(travelSystemService.getAreaProvinceList(countryId));
        }catch (Exception e){
            e.printStackTrace();
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("请求省份列表失败");
            logger.info("请求省份列表失败，失败信息：{}",e.getMessage());
        }
        return resultMsg;
    }
    @ApiOperation(value="城市列表", notes="城市列表" )
    @ApiImplicitParam(name = "provinceId", value = "省份ID", paramType = "query", required = true, dataType = "String")
    @ResponseBody
    @GetMapping("/getCityList")
    public ResultMsg<AreaCityDo> getCityList(@RequestParam(value = "provinceId", required = true) String provinceId){
        logger.info("请求城市列表开始,省份ID{}",provinceId);
        ResultMsg resultMsg=new ResultMsg();
        try{
            resultMsg.setData(travelSystemService.getAreaCityList(provinceId));
        }catch (Exception e){
            e.printStackTrace();
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("请求城市列表失败");
            logger.info("请求城市列表失败，失败信息：{}",e.getMessage());
        }
        return resultMsg;
    }
    @ApiOperation(value="区县列表", notes="区县列表" )
    @ApiImplicitParam(name = "cityId", value = "城市ID", paramType = "query", required = true, dataType = "String")
    @ResponseBody
    @GetMapping("/getCountyList")
    public ResultMsg<AreaCountyDo> getCountyList(@RequestParam(value = "cityId", required = true) String cityId){
        logger.info("请求区县列表开始，城市ID：{}",cityId);
        ResultMsg resultMsg=new ResultMsg();
        try{
            resultMsg.setData(travelSystemService.getAreaCountyList(cityId));
        }catch (Exception e){
            e.printStackTrace();
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("请求国家列表失败");
            logger.info("请求国家列表失败，失败信息：{}",e.getMessage());
        }
        return resultMsg;
    }

    @ApiOperation(value="房屋类型列表", notes="房屋类型列表" )
    @ResponseBody
    @GetMapping("/selectHourseTypeList")
    public ResultMsg<TravelHourseTypeDo> selectHourseTypeList(){
        logger.info("请求房屋类型列表开始");
        ResultMsg resultMsg=new ResultMsg();
        try{
            resultMsg.setData(travelSystemService.selectHourseTypeList());
        }catch (Exception e){
            e.printStackTrace();
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("请求房屋类型列表失败");
            logger.info("请求房屋类型列表失败，失败信息：{}",e.getMessage());
        }
        return resultMsg;
    }
    @ApiOperation(value="房屋类型详细列表", notes="房屋类型详细列表" )
    @ApiImplicitParam(name = "hourseTypeId", value = "房屋类型ID", paramType = "query", required = true, dataType = "String")
    @ResponseBody
    @GetMapping("/getHourseTypeDetailList")
    public ResultMsg<TravelHourseTypeDetailDo> getHourseTypeDetailList(@RequestParam(value = "hourseTypeId", required = true) String hourseTypeId){
        logger.info("请求房屋类型详细列表开始，房屋类型ID：{}",hourseTypeId);
        ResultMsg resultMsg=new ResultMsg();
        try{
            resultMsg.setData(travelSystemService.selectHourseTypeDetailList(hourseTypeId));
        }catch (Exception e){
            e.printStackTrace();
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("请求房屋类型详细列表失败");
            logger.info("请求房屋类型详细列表失败，失败信息：{}",e.getMessage());
        }
        return resultMsg;
    }
}
