package com.travel.travelapi.api.entity;

import lombok.Data;

@Data
public class TravelHourseType {
    private String id;

    private String typeName;

    private Integer status;

    private Integer sort;
}