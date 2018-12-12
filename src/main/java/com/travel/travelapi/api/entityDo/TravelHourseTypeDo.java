package com.travel.travelapi.api.entityDo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="房屋对象")
public class TravelHourseTypeDo extends BaseDo {
    @ApiModelProperty(value="房屋类型名称")
    private String typeName;
    @ApiModelProperty(value="是否可用，0不可用，1可用")
    private int status;
    @ApiModelProperty(value="排序")
    private int sort;
}