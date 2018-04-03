package com.pm.dsis.cm.dto;

import java.util.Date;

public class ElectricityAmount {
    private Long eaId;

    private Long userId;

    private String buildingFullRoom;

    private Float eaNumber;

    private Integer eaMonth;

    private Date eaBigenDate;

    private Date eaEndDate;

    private String eaWriter;

    private String eaFlag;
    //本月用量
    private float eaDosage;
    //本月费用
    private float monthFee;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private String attribute4;

    private String attribute5;

    private String attribute6;

    public float getEaDosage() {
        return eaDosage;
    }

    public void setEaDosage(float eaDosage) {
        this.eaDosage = eaDosage;
    }

    public float getMonthFee() {
        return monthFee;
    }

    public void setMonthFee(float monthFee) {
        this.monthFee = monthFee;
    }

    public String getBuildingFullRoom() {
        return buildingFullRoom;
    }

    public void setBuildingFullRoom(String buildingFullRoom) {
        this.buildingFullRoom = buildingFullRoom;
    }

    public Long getEaId() {
        return eaId;
    }

    public void setEaId(Long eaId) {
        this.eaId = eaId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Float getEaNumber() {
        return eaNumber;
    }

    public void setEaNumber(Float eaNumber) {
        this.eaNumber = eaNumber;
    }

    public Integer getEaMonth() {
        return eaMonth;
    }

    public void setEaMonth(Integer eaMonth) {
        this.eaMonth = eaMonth;
    }

    public Date getEaBigenDate() {
        return eaBigenDate;
    }

    public void setEaBigenDate(Date eaBigenDate) {
        this.eaBigenDate = eaBigenDate;
    }

    public Date getEaEndDate() {
        return eaEndDate;
    }

    public void setEaEndDate(Date eaEndDate) {
        this.eaEndDate = eaEndDate;
    }

    public String getEaWriter() {
        return eaWriter;
    }

    public void setEaWriter(String eaWriter) {
        this.eaWriter = eaWriter == null ? null : eaWriter.trim();
    }

    public String getEaFlag() {
        return eaFlag;
    }

    public void setEaFlag(String eaFlag) {
        this.eaFlag = eaFlag == null ? null : eaFlag.trim();
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