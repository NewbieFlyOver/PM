package com.pm.dsis.mm.dto;

/**
 * Created by admin on 2018/3/23.
 */

/**
 * 用于户主信息查询
 */
public class QueryUserInfo extends BuildingInfo {

    private Long userId;

    private String userName;

    private String userPhone;

    private String object;

    private String memberSituation;
    //房号全称：1-1-101
    private String roomName;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getMemberSituation() {
        return memberSituation;
    }

    public void setMemberSituation(String memberSituation) {
        this.memberSituation = memberSituation;
    }
}
