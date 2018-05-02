package com.pm.dsis.mm.dto;

import java.util.List;

public class UserInfo {
    private Long userId;

    private String userAccount;

    private String userPassword;

    private String userName;

    private String userNational;

    private String userGender;

    private String userNativePlace;

    private String userIdNumber;

    private String fixedTelephone;

    private String userQq;

    private String userEmail;

    private String userPhone;

    private String userWeChat;

    private String userBlog;

    private String userWorkUnits;

    private String userDepartment;

    private String userHomeAddress;

    private String userCorrespondenceAddress;

    private String userCarBrand;

    private String userHobby;

    private String emergencyContact;

    private String emergencyContactPhone;

    private String userTaboo;

    private String userNote;

    private String object;

    /**
     * 房屋全称，不存出数据库
     */
    private String buildingFullRoom;


    public String getBuildingFullRoom() {
        return buildingFullRoom;
    }

    public void setBuildingFullRoom(String buildingFullRoom) {
        this.buildingFullRoom = buildingFullRoom;
    }

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private String attribute4;

    private String attribute5;

    private String attribute6;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    private List<UserMember> userMemberList;

    public List<UserMember> getUserMemberList() {
        return userMemberList;
    }

    public void setUserMemberList(List<UserMember> userMemberList) {
        this.userMemberList = userMemberList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserNational() {
        return userNational;
    }

    public void setUserNational(String userNational) {
        this.userNational = userNational == null ? null : userNational.trim();
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender == null ? null : userGender.trim();
    }

    public String getUserNativePlace() {
        return userNativePlace;
    }

    public void setUserNativePlace(String userNativePlace) {
        this.userNativePlace = userNativePlace == null ? null : userNativePlace.trim();
    }

    public String getUserIdNumber() {
        return userIdNumber;
    }

    public void setUserIdNumber(String userIdNumber) {
        this.userIdNumber = userIdNumber == null ? null : userIdNumber.trim();
    }

    public String getFixedTelephone() {
        return fixedTelephone;
    }

    public void setFixedTelephone(String fixedTelephone) {
        this.fixedTelephone = fixedTelephone == null ? null : fixedTelephone.trim();
    }

    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq == null ? null : userQq.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserWeChat() {
        return userWeChat;
    }

    public void setUserWeChat(String userWeChat) {
        this.userWeChat = userWeChat == null ? null : userWeChat.trim();
    }

    public String getUserBlog() {
        return userBlog;
    }

    public void setUserBlog(String userBlog) {
        this.userBlog = userBlog == null ? null : userBlog.trim();
    }

    public String getUserWorkUnits() {
        return userWorkUnits;
    }

    public void setUserWorkUnits(String userWorkUnits) {
        this.userWorkUnits = userWorkUnits == null ? null : userWorkUnits.trim();
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment == null ? null : userDepartment.trim();
    }

    public String getUserHomeAddress() {
        return userHomeAddress;
    }

    public void setUserHomeAddress(String userHomeAddress) {
        this.userHomeAddress = userHomeAddress == null ? null : userHomeAddress.trim();
    }

    public String getUserCorrespondenceAddress() {
        return userCorrespondenceAddress;
    }

    public void setUserCorrespondenceAddress(String userCorrespondenceAddress) {
        this.userCorrespondenceAddress = userCorrespondenceAddress == null ? null : userCorrespondenceAddress.trim();
    }

    public String getUserCarBrand() {
        return userCarBrand;
    }

    public void setUserCarBrand(String userCarBrand) {
        this.userCarBrand = userCarBrand == null ? null : userCarBrand.trim();
    }

    public String getUserHobby() {
        return userHobby;
    }

    public void setUserHobby(String userHobby) {
        this.userHobby = userHobby == null ? null : userHobby.trim();
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

    public String getUserTaboo() {
        return userTaboo;
    }

    public void setUserTaboo(String userTaboo) {
        this.userTaboo = userTaboo == null ? null : userTaboo.trim();
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote == null ? null : userNote.trim();
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