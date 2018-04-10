package com.pm.dsis.gs.dto;

import java.util.Date;

public class GarageState {
    private Long gsId;

    private String gsNum;

    private Integer gsLocation;

    private String gsState;

    private Long userId;

    private Date vfBigenDate;

    private Date vfEndDate;

    private String vfBigenDateStr;

    private String vfEndDateStr;

    private String gsLicenNumber;

    private String buildingFullRoom;

    private String userName;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private String attribute4;

    private String attribute5;

    private String attribute6;

    public String getVfBigenDateStr() {
        return vfBigenDateStr;
    }

    public void setVfBigenDateStr(String vfBigenDateStr) {
        this.vfBigenDateStr = vfBigenDateStr;
    }

    public String getVfEndDateStr() {
        return vfEndDateStr;
    }

    public void setVfEndDateStr(String vfEndDateStr) {
        this.vfEndDateStr = vfEndDateStr;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGsLicenNumber() {
        return gsLicenNumber;
    }

    public void setGsLicenNumber(String gsLicenNumber) {
        this.gsLicenNumber = gsLicenNumber;
    }

    public String getBuildingFullRoom() {
        return buildingFullRoom;
    }

    public void setBuildingFullRoom(String buildingFullRoom) {
        this.buildingFullRoom = buildingFullRoom;
    }

    public Long getGsId() {
        return gsId;
    }

    public void setGsId(Long gsId) {
        this.gsId = gsId;
    }

    public String getGsNum() {
        return gsNum;
    }

    public void setGsNum(String gsNum) {
        this.gsNum = gsNum == null ? null : gsNum.trim();
    }

    public Integer getGsLocation() {
        return gsLocation;
    }

    public void setGsLocation(Integer gsLocation) {
        this.gsLocation = gsLocation;
    }

    public String getGsState() {
        return gsState;
    }

    public void setGsState(String gsState) {
        this.gsState = gsState == null ? null : gsState.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getVfBigenDate() {
        return vfBigenDate;
    }

    public void setVfBigenDate(Date vfBigenDate) {
        this.vfBigenDate = vfBigenDate;
    }

    public Date getVfEndDate() {
        return vfEndDate;
    }

    public void setVfEndDate(Date vfEndDate) {
        this.vfEndDate = vfEndDate;
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