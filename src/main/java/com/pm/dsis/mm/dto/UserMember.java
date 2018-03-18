package com.pm.dsis.mm.dto;

import java.util.List;

/**
 * 常住成员
 */
public class UserMember {
    private Long memberId;

    private Long userId;

    private String memberName;

    private String memberRelationship;

    private Integer memberAge;

    private String memberIdNumber;

    private String memberWorkUnits;

    private String memberPhone;

    private String memberSituation;

    private String memberSituationInstructions;

    private String memberNote;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private String attribute4;

    private String attribute5;

    private String attribute6;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public String getMemberRelationship() {
        return memberRelationship;
    }

    public void setMemberRelationship(String memberRelationship) {
        this.memberRelationship = memberRelationship == null ? null : memberRelationship.trim();
    }

    public Integer getMemberAge() {
        return memberAge;
    }

    public void setMemberAge(Integer memberAge) {
        this.memberAge = memberAge;
    }

    public String getMemberIdNumber() {
        return memberIdNumber;
    }

    public void setMemberIdNumber(String memberIdNumber) {
        this.memberIdNumber = memberIdNumber == null ? null : memberIdNumber.trim();
    }

    public String getMemberWorkUnits() {
        return memberWorkUnits;
    }

    public void setMemberWorkUnits(String memberWorkUnits) {
        this.memberWorkUnits = memberWorkUnits == null ? null : memberWorkUnits.trim();
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone == null ? null : memberPhone.trim();
    }

    public String getMemberSituation() {
        return memberSituation;
    }

    public void setMemberSituation(String memberSituation) {
        this.memberSituation = memberSituation == null ? null : memberSituation.trim();
    }

    public String getMemberSituationInstructions() {
        return memberSituationInstructions;
    }

    public void setMemberSituationInstructions(String memberSituationInstructions) {
        this.memberSituationInstructions = memberSituationInstructions == null ? null : memberSituationInstructions.trim();
    }

    public String getMemberNote() {
        return memberNote;
    }

    public void setMemberNote(String memberNote) {
        this.memberNote = memberNote == null ? null : memberNote.trim();
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