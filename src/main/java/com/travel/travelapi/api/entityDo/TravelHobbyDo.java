package com.travel.travelapi.api.entityDo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="爱好")
@Data
public class TravelHobbyDo extends BaseDo{

    @ApiModelProperty(value="爱好名")
    private String name;
    @ApiModelProperty(value="爱好图片路径")
    private String impPath;
    @ApiModelProperty(value="状态，0未上架，1已上架")
    private int status;
}