package com.travel.travelapi.api.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TravelHoppy {
    private String id;

    private String name;

    private String impPath;

    private Integer status;

    private Date createTime;

    private Date updateTime;
}