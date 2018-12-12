package com.travel.travelapi.api.entity;

import lombok.Data;

@Data
public class TravelUser {
    private String id;

    private String mobilePhone;

    private String password;

    private String qqNumber;

    private String weiBo;

    private String weChat;

    private String qqNumberName;

    private String weiBoName;

    private String weChatName;

    private String headPic;

    private String backPic;

    private String email;

    private String idFront;

    private String idBehind;

    private String trueName;

    private Integer isPass;

    private String idCardNo;
}