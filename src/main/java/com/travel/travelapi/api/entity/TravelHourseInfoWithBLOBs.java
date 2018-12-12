package com.travel.travelapi.api.entity;

import lombok.Data;

@Data
public class TravelHourseInfoWithBLOBs extends TravelHourseInfo {
    private String hourseDetail;

    private String ruleOfUnsubscribe;

}