package com.pm.dsis.fee.dto;

public class ElectricityUnitPrice {
    private Long eaUrId;

    private Float eaUrCeiling;

    private Float eaUrLower;

    private Float eaUrPrice;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private String attribute4;

    private String attribute5;

    private String attribute6;

    public Long getEaUrId() {
        return eaUrId;
    }

    public void setEaUrId(Long eaUrId) {
        this.eaUrId = eaUrId;
    }

    public Float getEaUrCeiling() {
        return eaUrCeiling;
    }

    public void setEaUrCeiling(Float eaUrCeiling) {
        this.eaUrCeiling = eaUrCeiling;
    }

    public Float getEaUrLower() {
        return eaUrLower;
    }

    public void setEaUrLower(Float eaUrLower) {
        this.eaUrLower = eaUrLower;
    }

    public Float getEaUrPrice() {
        return eaUrPrice;
    }

    public void setEaUrPrice(Float eaUrPrice) {
        this.eaUrPrice = eaUrPrice;
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