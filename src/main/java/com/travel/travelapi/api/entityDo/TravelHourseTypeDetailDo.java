package com.travel.travelapi.api.entityDo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="房屋详细类型对象")
public class TravelHourseTypeDetailDo extends BaseDo {
    @ApiModelProperty(value="关联房屋类型ID")
    private String hourseTypeId;
    @ApiModelProperty(value="房屋类型详细名称")
    private String typeDetailName;
    @ApiModelProperty(value="是否可用，0不可用，1可用")
    private int status;
    @ApiModelProperty(value="排序")
    private int sort;
}