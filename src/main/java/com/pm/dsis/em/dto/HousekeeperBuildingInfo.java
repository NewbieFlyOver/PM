package com.pm.dsis.em.dto;

import java.util.Date;

public class HousekeeperBuildingInfo {
    private Long hbId;

    private String hbAccount;

    private String hbPassword;

    private String hbName;

    private String hbNational;

    private String hbGender;

    private String hbNativePlace;

    private String hbPhone;

    private String hbWorkPhone;

    private String hbEmail;

    private String hbIdNumber;

    private String hbHomeAddress;

    private String emergencyContact;

    private String emergencyContactPhone;

    private String hbPosition;

    private String hbRole;

    private Date hbInductionDate;

    private String hbInductionDateStr;

    private String hbStatus;

    private String hbStatusFalg;

    /* 工号
     */
    private Long hbNumber;

    public String getHbInductionDateStr() {
        return hbInductionDateStr;
    }

    public void setHbInductionDateStr(String hbInductionDateStr) {
        this.hbInductionDateStr = hbInductionDateStr;
    }

    public Long getHbNumber() {
        return hbNumber;
    }

    public void setHbNumber(Long hbNumber) {
        this.hbNumber = hbNumber;
    }

    public Date getHbInductionDate() {
        return hbInductionDate;
    }

    public void setHbInductionDate(Date hbInductionDate) {
        this.hbInductionDate = hbInductionDate;
    }

    public String getHbStatus() {
        return hbStatus;
    }

    public void setHbStatus(String hbStatus) {
        this.hbStatus = hbStatus;
    }

    public String getHbStatusFalg() {
        return hbStatusFalg;
    }

    public void setHbStatusFalg(String hbStatusFalg) {
        this.hbStatusFalg = hbStatusFalg;
    }

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private String attribute4;

    private String attribute5;

    private String attribute6;

    public Long getHbId() {
        return hbId;
    }

    public void setHbId(Long hbId) {
        this.hbId = hbId;
    }

    public String getHbAccount() {
        return hbAccount;
    }

    public void setHbAccount(String hbAccount) {
        this.hbAccount = hbAccount == null ? null : hbAccount.trim();
    }

    public String getHbPassword() {
        return hbPassword;
    }

    public void setHbPassword(String hbPassword) {
        this.hbPassword = hbPassword == null ? null : hbPassword.trim();
    }

    public String getHbName() {
        return hbName;
    }

    public void setHbName(String hbName) {
        this.hbName = hbName == null ? null : hbName.trim();
    }

    public String getHbNational() {
        return hbNational;
    }

    public void setHbNational(String hbNational) {
        this.hbNational = hbNational == null ? null : hbNational.trim();
    }

    public String getHbGender() {
        return hbGender;
    }

    public void setHbGender(String hbGender) {
        this.hbGender = hbGender == null ? null : hbGender.trim();
    }

    public String getHbNativePlace() {
        return hbNativePlace;
    }

    public void setHbNativePlace(String hbNativePlace) {
        this.hbNativePlace = hbNativePlace == null ? null : hbNativePlace.trim();
    }

    public String getHbPhone() {
        return hbPhone;
    }

    public void setHbPhone(String hbPhone) {
        this.hbPhone = hbPhone == null ? null : hbPhone.trim();
    }

    public String getHbWorkPhone() {
        return hbWorkPhone;
    }

    public void setHbWorkPhone(String hbWorkPhone) {
        this.hbWorkPhone = hbWorkPhone == null ? null : hbWorkPhone.trim();
    }

    public String getHbEmail() {
        return hbEmail;
    }

    public void setHbEmail(String hbEmail) {
        this.hbEmail = hbEmail == null ? null : hbEmail.trim();
    }

    public String getHbIdNumber() {
        return hbIdNumber;
    }

    public void setHbIdNumber(String hbIdNumber) {
        this.hbIdNumber = hbIdNumber == null ? null : hbIdNumber.trim();
    }

    public String getHbHomeAddress() {
        return hbHomeAddress;
    }

    public void setHbHomeAddress(String hbHomeAddress) {
        this.hbHomeAddress = hbHomeAddress == null ? null : hbHomeAddress.trim();
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact == null ? null : emergencyContact.trim();
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone == null ? null : emergencyContactPhone.trim();
    }

    public String getHbPosition() {
        return hbPosition;
    }

    public void setHbPosition(String hbPosition) {
        this.hbPosition = hbPosition == null ? null : hbPosition.trim();
    }

    public String getHbRole() {
        return hbRole;
    }

    public void setHbRole(String hbRole) {
        this.hbRole = hbRole == null ? null : hbRole.trim();
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