package com.pm.dsis.mm.dto;

import java.util.Date;

public class BuildingInfo {
    private Long buildingId;

    private Long userId;

    private Long buildingTypeId;

    private String buildingCommunity;

    private String buildingTheater;

    private String buildingUnit;

    private String buildingFloor;

    private String buildingRoom;

    private Float buildingArea;

    private String housingUsage;

    private Date checkinDate;

    private Date stayinDate;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private String attribute4;

    private String attribute5;

    private String attribute6;

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBuildingTypeId() {
        return buildingTypeId;
    }

    public void setBuildingTypeId(Long buildingTypeId) {
        this.buildingTypeId = buildingTypeId;
    }

    public String getBuildingCommunity() {
        return buildingCommunity;
    }

    public void setBuildingCommunity(String buildingCommunity) {
        this.buildingCommunity = buildingCommunity == null ? null : buildingCommunity.trim();
    }

    public String getBuildingTheater() {
        return buildingTheater;
    }

    public void setBuildingTheater(String buildingTheater) {
        this.buildingTheater = buildingTheater == null ? null : buildingTheater.trim();
    }

    public String getBuildingUnit() {
        return buildingUnit;
    }

    public void setBuildingUnit(String buildingUnit) {
        this.buildingUnit = buildingUnit == null ? null : buildingUnit.trim();
    }

    public String getBuildingFloor() {
        return buildingFloor;
    }

    public void setBuildingFloor(String buildingFloor) {
        this.buildingFloor = buildingFloor == null ? null : buildingFloor.trim();
    }

    public String getBuildingRoom() {
        return buildingRoom;
    }

    public void setBuildingRoom(String buildingRoom) {
        this.buildingRoom = buildingRoom == null ? null : buildingRoom.trim();
    }

    public Float getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(Float buildingArea) {
        this.buildingArea = buildingArea;
    }

    public String getHousingUsage() {
        return housingUsage;
    }

    public void setHousingUsage(String housingUsage) {
        this.housingUsage = housingUsage == null ? null : housingUsage.trim();
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getStayinDate() {
        return stayinDate;
    }

    public void setStayinDate(Date stayinDate) {
        this.stayinDate = stayinDate;
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