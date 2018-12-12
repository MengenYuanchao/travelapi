package com.travel.travelapi.api.entityDo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@ApiModel(value="房屋对象")
public class TravelHourseInfoDo extends BaseDo{
    @ApiModelProperty(value="用户ID")
    private String userId;
    @ApiModelProperty(value="房屋类型名称")
    private String hourseTypeName;
    @ApiModelProperty(value="房屋详细类型名称")
    private String hourseTypeDetailName;
    @ApiModelProperty(value="国家")
    private String countryName;
    @ApiModelProperty(value="省份")
    private String provinceName;
    @ApiModelProperty(value="城市")
    private String cityName;
    @ApiModelProperty(value="区县")
    private String countyName;
    @ApiModelProperty(value="详细地址")
    private String address;
    @ApiModelProperty(value="最多客房人数")
    private int roomPersonNum;
    @ApiModelProperty(value="卧室数量")
    private int bedroomNum;
    @ApiModelProperty(value="床铺")
    private int bedNum;
    @ApiModelProperty(value="洗手间")
    private int bathroomNum;
    @ApiModelProperty(value="价格")
    private double price;
    @ApiModelProperty(value="评价数量")
    private int evaluateNum;
    @ApiModelProperty(value="房屋图片")
    private String hourseImage;
    @ApiModelProperty(value="入住时间")
    private String checkInTime;
    @ApiModelProperty(value="退房时间")
    private String checkOutTime;
    @ApiModelProperty(value="是否可用，0不可用，1可用")
    private int status;
}