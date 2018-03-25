package com.pm.dsis.cm.dto;

import java.util.Date;

public class WaterAmount {
    private Long waId;

    private Long userId;

    private String buildingFullRoom;

    private Float waNumber;

    private Integer waMonth;

    private Date waBigenDate;

    private Date waEndDate;

    private String waWriter;

    private String waFlag;

    //本月用量
    private Long waDosage;
    //本月费用
    private Long monthFee;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private String attribute4;

    private String attribute5;

    private String attribute6;

    public Long getWaDosage() {
        return waDosage;
    }

    public void setWaDosage(Long waDosage) {
        this.waDosage = waDosage;
    }

    public Long getMonthFee() {
        return monthFee;
    }

    public void setMonthFee(Long monthFee) {
        this.monthFee = monthFee;
    }

    public String getBuildingFullRoom() {
        return buildingFullRoom;
    }

    public void setBuildingFullRoom(String buildingFullRoom) {
        this.buildingFullRoom = buildingFullRoom;
    }

    public Long getWaId() {
        return waId;
    }

    public void setWaId(Long waId) {
        this.waId = waId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Float getWaNumber() {
        return waNumber;
    }

    public void setWaNumber(Float waNumber) {
        this.waNumber = waNumber;
    }

    public Integer getWaMonth() {
        return waMonth;
    }

    public void setWaMonth(Integer waMonth) {
        this.waMonth = waMonth;
    }

    public Date getWaBigenDate() {
        return waBigenDate;
    }

    public void setWaBigenDate(Date waBigenDate) {
        this.waBigenDate = waBigenDate;
    }

    public Date getWaEndDate() {
        return waEndDate;
    }

    public void setWaEndDate(Date waEndDate) {
        this.waEndDate = waEndDate;
    }

    public String getWaWriter() {
        return waWriter;
    }

    public void setWaWriter(String waWriter) {
        this.waWriter = waWriter == null ? null : waWriter.trim();
    }

    public String getWaFlag() {
        return waFlag;
    }

    public void setWaFlag(String waFlag) {
        this.waFlag = waFlag == null ? null : waFlag.trim();
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