package com.travel.travelapi.api.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TravelBanner {
    private String id;

    private Integer isJump;

    private Integer jumpType;

    private String httpUrl;

    private String bannerUrl;

    private Integer bannerType;

    private Date createTime;

    private Date updateTime;
}