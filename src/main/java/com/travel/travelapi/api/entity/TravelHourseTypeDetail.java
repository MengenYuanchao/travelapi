package com.travel.travelapi.api.entity;

import lombok.Data;

@Data
public class TravelHourseTypeDetail {
    private String id;

    private String hourseTypeId;

    private String typeDetailName;

    private Integer status;

    private Integer sort;
}