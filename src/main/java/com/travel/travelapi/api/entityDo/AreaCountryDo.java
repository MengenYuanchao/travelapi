package com.travel.travelapi.api.entityDo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="国家对象")
public class AreaCountryDo extends BaseDo {
    @ApiModelProperty(value="国家名称")
    private String name;
    @ApiModelProperty(value="是否可用，0不可用，1可用")
    private int status;
}