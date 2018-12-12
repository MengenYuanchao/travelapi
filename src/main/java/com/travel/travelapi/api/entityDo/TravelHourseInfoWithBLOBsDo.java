package com.travel.travelapi.api.entityDo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="房屋详细对象")
public class TravelHourseInfoWithBLOBsDo extends TravelHourseInfoDo {
    @ApiModelProperty(value="房屋描述")
    private String hourseDetail;
    @ApiModelProperty(value="退订规则")
    private String ruleOfUnsubscribe;
}