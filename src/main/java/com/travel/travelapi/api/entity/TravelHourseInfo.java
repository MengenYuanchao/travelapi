package com.travel.travelapi.api.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TravelHourseInfo {
    private String id;

    private String userId;

    private String hourseTypeName;

    private String hourseTypeDetailName;

    private String countryName;

    private String provinceName;

    private String cityName;

    private String countyName;

    private String address;

    private Integer roomPersonNum;

    private Integer bedroomNum;

    private Integer bedNum;

    private Integer bathroomNum;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private Date checkInTime;

    private Date checkOutTime;

    private String hourseImage;
}