package com.travel.travelapi.api.entityDo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="省市对象")
public class AreaProvinceDo extends BaseDo {
    @ApiModelProperty(value="关联国家ID")
    private String countryId;
    @ApiModelProperty(value="省份名称")
    private String name;
    @ApiModelProperty(value="是否可用，0不可用，1可用")
    private int status;
}