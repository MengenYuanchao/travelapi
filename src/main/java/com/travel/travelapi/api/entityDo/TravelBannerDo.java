package com.travel.travelapi.api.entityDo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value="banner对象")
public class TravelBannerDo extends BaseDo{

    @ApiModelProperty(value="是否可跳转0不可跳转，1可跳转")
    private int isJump;
    @ApiModelProperty(value="跳转类型，1内部，2外部")
    private int jumpType;
    @ApiModelProperty(value="跳转外部URL")
    private String httpUrl;
    @ApiModelProperty(value="baner图URL")
    private String bannerUrl;
    @ApiModelProperty(value="banner图类型，1banner图,2心愿单")
    private int bannerType;
    @ApiModelProperty(value="创建时间")
    private String createTime;
    @ApiModelProperty(value="修改时间")
    private String updateTime;
    @ApiModelProperty(value="是否可用，0不可用，1可用")
    private int status;
    @ApiModelProperty(value="排序")
    private int sort;
}