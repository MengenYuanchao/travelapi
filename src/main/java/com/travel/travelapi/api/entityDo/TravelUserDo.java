package com.travel.travelapi.api.entityDo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="用户")
@Data
public class TravelUserDo extends BaseDo{

    @ApiModelProperty(value="手机号")
    private String mobilePhone;
    private String password;
    @ApiModelProperty(value="QQ号")
    private String qqNumber;
    @ApiModelProperty(value="微博号")
    private String weiBo;
    @ApiModelProperty(value="微信号")
    private String weChat;
    @ApiModelProperty(value="QQ昵称")
    private String qqNumberName;
    @ApiModelProperty(value="微博昵称")
    private String weiBoName;
    @ApiModelProperty(value="微信昵称")
    private String weChatName;
    @ApiModelProperty(value="头像")
    private String headPic;
    @ApiModelProperty(value="背景图片")
    private String backPic;
    @ApiModelProperty(value="登录类型，1验证码登录，2手机密码登录，3微信登录，4qq登录，5微博登录，6邮箱密码登录",required = true)
    private int  type;
    @ApiModelProperty(value="邮箱")
    private String email;
    @ApiModelProperty(value="身份证正面照URL")
    private String idFront;
    @ApiModelProperty(value="身份证反面照URL")
    private String idBehind;
    @ApiModelProperty(value="认证姓名")
    private String trueName;
    @ApiModelProperty(value="是否认证通过，0未通过，1已通过")
    private int isPass;
    @ApiModelProperty(value="身份证号")
    private String idCardNo;
}