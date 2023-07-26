package com.china.model;

import com.china.anno.TimeInterval;


@TimeInterval(startTime = "openTime",endTime = "closeTime",message = "角色启用时间不能大于停用时间")
public class Role {

    private String openTime;

    private String closeTime;

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }
}
