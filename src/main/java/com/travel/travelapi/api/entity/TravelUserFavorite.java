package com.travel.travelapi.api.entity;

import java.util.Date;

public class TravelUserFavorite {
    private String id;

    private String hourseInfoId;

    private String userId;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getHourseInfoId() {
        return hourseInfoId;
    }

    public void setHourseInfoId(String hourseInfoId) {
        this.hourseInfoId = hourseInfoId == null ? null : hourseInfoId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}