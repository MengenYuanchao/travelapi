package com.travel.travelapi.api.entity;

import lombok.Data;

@Data
public class AreaCounty {
    private String id;

    private String countyName;

    private String cityId;

    private Integer status;
}