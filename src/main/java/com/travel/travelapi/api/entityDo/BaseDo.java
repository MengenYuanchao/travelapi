package com.travel.travelapi.api.entityDo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="父对象")
@Data
public class BaseDo {
    @ApiModelProperty(value="ID")
    private String id;
}
