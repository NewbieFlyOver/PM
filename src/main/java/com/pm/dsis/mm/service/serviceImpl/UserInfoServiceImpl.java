package com.pm.dsis.mm.service.serviceImpl;

import com.pm.dsis.mm.dto.*;

import com.pm.dsis.mm.mapper.*;
import com.pm.dsis.mm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by admin on 2018/3/18.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserMemberMapper userMemberMapper;

    @Autowired
    private BuildingInfoMapper buildingInfoMapper;

    @Autowired
    private QueryUserInfoMapper queryUserInfoMapper;

    @Autowired
    private BuildingTypeMapper buildingTypeMapper;


    public int insertUserInfo(UserInfo userInfo){
            return userInfoMapper.updateByUserId(userInfo);
    }

    public int addUserInfo(UserInfo userInfo){
        return userInfoMapper.insertUserInfo(userInfo);
    }

    public Long queryUserId(){
        return userInfoMapper.queryUserId();
    }

    public UserInfo selectByUserId(Long userId) {
        return userInfoMapper.selectByUserId(userId);
    }

    @Transactional
    public void insertUserMember(List<UserMember> userMemberList){

        for (UserMember userMember:userMemberList) {
            Long id = userMember.getMemberId();
            if("".equals(id)||null==id ){
                userMemberMapper.insertUserMember(userMember);
            }else{
                userMemberMapper.updateUserMember(userMember);
            }

        }
    }


    public List<UserMember> selectAllUserMember(){
        return userMemberMapper.selectAllUserMember();
    }

    public List<UserMember> selectMemberByUserId(Long userId){
        return userMemberMapper.selectMemberByUserId(userId);
    }


    public void deleteById(List<UserMember> userMemberList){

        for (UserMember userMember:userMemberList) {
            userMemberMapper.deleteById(userMember.getMemberId());
        }
    }

    public int insertBuildingInfo(BuildingInfo buildingInfo){

        String buildingFullRoom = buildingInfo.getBuildingTheater()+"-"+buildingInfo.getBuildingUnit()+"-"+buildingInfo.getBuildingRoom();
        buildingInfo.setBuildingFullRoom(buildingFullRoom);
        if (null == buildingInfo.getBuildingId()) {
            return buildingInfoMapper.insertBuildingInfo(buildingInfo);
        }else{
            return  buildingInfoMapper.updateByBuildId(buildingInfo);
        }

    }

    public BuildingInfo selectBuildById(Long userId){
        BuildingInfo buildingInfo =  buildingInfoMapper.selectBuildById(userId);
       // buildingInfo.setCheckinStrDate(getStringDateShort(buildingInfo.getCheckinDate()));
        return buildingInfoMapper.selectBuildById(userId);
    }

    public String getStringDateShort(Date time) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(1521734400000L);
        return dateString;
    }


    public List<QueryUserInfo> queryAllUserInfo(QueryUserInfo queryUserInfo){
        List<QueryUserInfo> queryUserInfoList = queryUserInfoMapper.queryAllUserInfo(queryUserInfo);
        //拼接房号，如：1-1-101
        for (QueryUserInfo q: queryUserInfoList){
            String roomName = q.getBuildingTheater()+"-"+q.getBuildingUnit()+"-"+q.getBuildingRoom();
            q.setRoomName(roomName);
        }
        return queryUserInfoList;
    }

    public List<BuildingType> selectAllType(){
        return buildingTypeMapper.selectAllType();
    }
}
