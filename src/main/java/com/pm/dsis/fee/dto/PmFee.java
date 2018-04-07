package com.pm.dsis.fee.dto;

import java.util.Date;

public class PmFee {
    private Long pmId;

    private Long userId;

    private String buildingFullRoom;

    private Long pmUpId;

    private Float energy;

    private Integer pmMonth;

    private Date pmBeginDate;

    private Date pmEndDate;

    private String pmFlag;

    private String pmObject;

    private Float monthFee;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private String attribute4;

    private String attribute5;

    private String attribute6;

    public String getBuildingFullRoom() {
        return buildingFullRoom;
    }

    public void setBuildingFullRoom(String buildingFullRoom) {
        this.buildingFullRoom = buildingFullRoom;
    }

    public Long getPmId() {
        return pmId;
    }

    public void setPmId(Long pmId) {
        this.pmId = pmId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPmUpId() {
        return pmUpId;
    }

    public void setPmUpId(Long pmUpId) {
        this.pmUpId = pmUpId;
    }

    public Float getEnergy() {
        return energy;
    }

    public void setEnergy(Float energy) {
        this.energy = energy;
    }

    public Integer getPmMonth() {
        return pmMonth;
    }

    public void setPmMonth(Integer pmMonth) {
        this.pmMonth = pmMonth;
    }

    public Date getPmBeginDate() {
        return pmBeginDate;
    }

    public void setPmBeginDate(Date pmBeginDate) {
        this.pmBeginDate = pmBeginDate;
    }

    public Date getPmEndDate() {
        return pmEndDate;
    }

    public void setPmEndDate(Date pmEndDate) {
        this.pmEndDate = pmEndDate;
    }

    public String getPmFlag() {
        return pmFlag;
    }

    public void setPmFlag(String pmFlag) {
        this.pmFlag = pmFlag == null ? null : pmFlag.trim();
    }

    public String getPmObject() {
        return pmObject;
    }

    public void setPmObject(String pmObject) {
        this.pmObject = pmObject == null ? null : pmObject.trim();
    }

    public Float getMonthFee() {
        return monthFee;
    }

    public void setMonthFee(Float monthFee) {
        this.monthFee = monthFee;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1 == null ? null : attribute1.trim();
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2 == null ? null : attribute2.trim();
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3 == null ? null : attribute3.trim();
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4 == null ? null : attribute4.trim();
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5 == null ? null : attribute5.trim();
    }

    public String getAttribute6() {
        return attribute6;
    }

    public void setAttribute6(String attribute6) {
        this.attribute6 = attribute6 == null ? null : attribute6.trim();
    }
}