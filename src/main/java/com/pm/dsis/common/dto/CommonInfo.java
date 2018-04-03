package com.pm.dsis.common.dto;

/**
 * Created by admin on 2018/4/2.
 */
public class CommonInfo {

    private Long commonId;

    private String commonType;

    private String commonName;

    private String commonValue;

    public Long getCommonId() {
        return commonId;
    }

    public void setCommonId(Long commonId) {
        this.commonId = commonId;
    }

    public String getCommonType() {
        return commonType;
    }

    public void setCommonType(String commonType) {
        this.commonType = commonType;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getCommonValue() {
        return commonValue;
    }

    public void setCommonValue(String commonValue) {
        this.commonValue = commonValue;
    }
}
