package com.travel.travelapi.api.entity;

import lombok.Data;

@Data
public class AreaCity {
    private String id;

    private String provinceId;

    private String cityName;

    private Integer status;
}