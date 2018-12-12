package com.travel.travelapi.api.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TravelHourseCalendarPrice {
    private String id;

    private String hourseInfoId;

    private Date date;

    private BigDecimal price;

    private Integer leasable;
}