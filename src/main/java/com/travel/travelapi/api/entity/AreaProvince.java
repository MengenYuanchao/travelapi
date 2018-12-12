package com.travel.travelapi.api.entity;

import lombok.Data;

@Data
public class AreaProvince {
    private String id;

    private String countryId;

    private String name;

    private Integer status;
}