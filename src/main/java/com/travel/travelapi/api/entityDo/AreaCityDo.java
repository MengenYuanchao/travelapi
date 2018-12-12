package com.travel.travelapi.api.entityDo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="城市对象")
public class AreaCityDo  extends  BaseDo{
    @ApiModelProperty(value="关联省份ID")
    private String provinceId;
    @ApiModelProperty(value="城市名称")
    private String cityName;
    @ApiModelProperty(value="是否可用，0不可用，1可用")
    private int status;
}