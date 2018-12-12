package com.travel.travelapi.api.controller;

import com.travel.travelapi.api.entityDo.TravelHobbyDo;
import com.travel.travelapi.api.service.TravelHobbyService;
import com.travel.travelapi.base.ResultMsg;
import com.travel.travelapi.enumUtils.ResultEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travelUserHobby")
@Api(value = "用户爱好",description = "用户爱好")
public class TravelUserHobbyController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TravelHobbyService travelHobbyService;

    @ApiOperation(value="爱好列表", notes="爱好列表" )
    @ResponseBody
    @PostMapping("/getHobbyList")
    public ResultMsg<TravelHobbyDo> hobbyList(){
        logger.info("获取爱好列表信息：");
        ResultMsg resultMsg=new ResultMsg();
        try{
            List<TravelHobbyDo> travelHobbyDoList = travelHobbyService.selectHobbyList();
            resultMsg.setData(travelHobbyDoList);

        }catch (Exception e){
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("获取爱好列表信息失败");
            logger.info("获取获取爱好列表信息失败：{1}",e.getMessage());
        }
        return resultMsg;
    }

    @ApiOperation(value="保存用户爱好信息", notes="保存用户爱好信息" )
    @ResponseBody
    @PostMapping("/insertUserHobby")
    public ResultMsg insertUserHobby(@ApiParam(name="hobbyIds",value="爱好数组形式",required=true) @RequestParam String[] hobbyIds,
                                     @ApiParam(name="userId",value="用户ID",required=true) @RequestParam String userId){
        logger.info("修改用户爱好信息，用户ID：{}，爱好列表：{}",new Object[]{userId,hobbyIds});
        ResultMsg resultMsg=new ResultMsg();
        try{
            travelHobbyService.insertUserHobby(userId,hobbyIds);
        }catch (Exception e){
            resultMsg.setCode(ResultEnum.ERROR_CODE.getCode());
            resultMsg.setMsg("修改用户爱好失败");
            logger.info("修改用户爱好信息失败：{1}",e.getMessage());
        }
        return resultMsg;
    }



}
