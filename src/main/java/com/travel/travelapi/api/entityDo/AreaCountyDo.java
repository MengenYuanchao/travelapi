package com.travel.travelapi.api.entityDo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="区县对象")
public class AreaCountyDo extends BaseDo{
    @ApiModelProperty(value="区县名称")
    private String countyName;
    @ApiModelProperty(value="关联城市ID")
    private String cityId;
    @ApiModelProperty(value="是否可用，0不可用，1可用")
    private int status;
}