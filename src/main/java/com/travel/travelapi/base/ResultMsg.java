package com.travel.travelapi.base;

import com.travel.travelapi.enumUtils.ResultEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@ApiModel("返回信息")
@Data
public class ResultMsg<T>{

    @ApiModelProperty(value="返回码")
    private int code;
    @ApiModelProperty(value="描述")
    private String msg;
    @ApiModelProperty(value="数据信息")
    private T data;

    public ResultMsg(){
        this.setCode(ResultEnum.SUCCESS_CODE.getCode());
        this.setMsg(ResultEnum.SUCCESS_CODE.getMsg());
        this.setData(data);
    }
}
