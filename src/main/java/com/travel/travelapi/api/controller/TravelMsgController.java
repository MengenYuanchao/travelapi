package com.travel.travelapi.api.controller;

import com.travel.travelapi.base.ResultMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/travelMsg")
@Api("消息")
public class TravelMsgController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


    @ApiOperation(value="用户登录", notes="登录" )
    @ResponseBody
    @PostMapping("/userLogin")
    public ResultMsg userLogin(){

        return new ResultMsg();
    }
}
