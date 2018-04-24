package com.pm.dsis.repair.dto;

import java.util.Date;

public class RepairInfo {
    private Long riId;

    private Long userId;

    private String riType;

    private String riLocation;

    private String riPeople;

    private String riPhone;

    private String riContent;

    private String riImg;

    private Date riDate;

    private String riDateStr;

    private String riFlag;

    private String riDealPeople;

    private Date riDealDate;

    private String riDealSituation;

    private String riNote;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private String attribute4;

    private String attribute5;

    private String attribute6;

    public String getRiDateStr() {
        return riDateStr;
    }

    public void setRiDateStr(String riDateStr) {
        this.riDateStr = riDateStr;
    }

    public String getRiLocation() {
        return riLocation;
    }

    public String getRiPhone() {
        return riPhone;
    }

    public void setRiPhone(String riPhone) {
        this.riPhone = riPhone;
    }

    public String getRiPeople() {
        return riPeople;
    }

    public void setRiPeople(String riPeople) {
        this.riPeople = riPeople;
    }

    public void setRiLocation(String riLocation) {
        this.riLocation = riLocation;
    }

    public String getRiImg() {
        return riImg;
    }

    public void setRiImg(String riImg) {
        this.riImg = riImg;
    }

    public Long getRiId() {
        return riId;
    }

    public void setRiId(Long riId) {
        this.riId = riId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRiType() {
        return riType;
    }

    public void setRiType(String riType) {
        this.riType = riType == null ? null : riType.trim();
    }

    public String getRiContent() {
        return riContent;
    }

    public void setRiContent(String riContent) {
        this.riContent = riContent == null ? null : riContent.trim();
    }

    public Date getRiDate() {
        return riDate;
    }

    public void setRiDate(Date riDate) {
        this.riDate = riDate;
    }

    public String getRiFlag() {
        return riFlag;
    }

    public void setRiFlag(String riFlag) {
        this.riFlag = riFlag == null ? null : riFlag.trim();
    }

    public String getRiDealPeople() {
        return riDealPeople;
    }

    public void setRiDealPeople(String riDealPeople) {
        this.riDealPeople = riDealPeople == null ? null : riDealPeople.trim();
    }

    public Date getRiDealDate() {
        return riDealDate;
    }

    public void setRiDealDate(Date riDealDate) {
        this.riDealDate = riDealDate;
    }

    public String getRiDealSituation() {
        return riDealSituation;
    }

    public void setRiDealSituation(String riDealSituation) {
        this.riDealSituation = riDealSituation == null ? null : riDealSituation.trim();
    }

    public String getRiNote() {
        return riNote;
    }

    public void setRiNote(String riNote) {
        this.riNote = riNote == null ? null : riNote.trim();
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

    @Override
    public String toString() {
        return "RepairInfo{" +
                "riId=" + riId +
                ", userId=" + userId +
                ", riType='" + riType + '\'' +
                ", riLocation='" + riLocation + '\'' +
                ", riPeople='" + riPeople + '\'' +
                ", riPhone='" + riPhone + '\'' +
                ", riContent='" + riContent + '\'' +
                ", riImg='" + riImg + '\'' +
                ", riDate=" + riDate +
                ", riFlag='" + riFlag + '\'' +
                ", riDealPeople='" + riDealPeople + '\'' +
                ", riDealDate=" + riDealDate +
                ", riDealSituation='" + riDealSituation + '\'' +
                ", riNote='" + riNote + '\'' +
                '}';
    }
}