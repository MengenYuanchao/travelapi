package com.travel.travelapi.api.entityDo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value="日历对象")
public class TravelHourseCalendarPriceDo extends BaseDo {
    @ApiModelProperty(value="房屋ID")
    private String hourseInfoId;
    @ApiModelProperty(value="日期")
    private String date;
    @ApiModelProperty(value="价格")
    private double price;
    @ApiModelProperty(value="是否可租，0可出租，1已租，2不可租")
    private int leasable;
}