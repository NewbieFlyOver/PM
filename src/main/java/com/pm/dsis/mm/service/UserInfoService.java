package com.pm.dsis.mm.service;

import com.pm.dsis.mm.dto.*;

import java.util.List;

/**
 * Created by admin on 2018/3/18.
 */
public interface UserInfoService {
    /**
     * 添加/更新户主信息
     * @param userInfo
     * @return
     */
    int insertUserInfo(UserInfo userInfo);

    /**
     * 新建户主信息
     * @param userInfo
     * @return
     */
    int addUserInfo(UserInfo userInfo);

    /**
     * 查询最新的userId
     * @return
     */
    Long queryUserId();

    /**
     * 根据户主id查询信息
     * @param userId
     * @return
     */
    UserInfo selectByUserId(Long userId);

    /**
     * 添加/更新常住人员的信息
     * @param userMemberList
     * @return
     */
    void insertUserMember(List<UserMember> userMemberList);


    /**
     * 查询所有常住人员的信息
     * @return
     */
    List<UserMember> selectAllUserMember();

    /**
     * 根据户主id查询常住人员
     * @param userId
     * @return
     */
    List<UserMember> selectMemberByUserId(Long userId);

    /**
     * 根据id删除常住人员的信息
     * @param userMemberList
     * @return
     */
    void deleteById(List<UserMember> userMemberList);

    /**
     * 添加户主房屋信息
     * @param buildingInfo
     * @return
     */
    int insertBuildingInfo(BuildingInfo buildingInfo);

    /**
     * 根据户主id查询房屋信息
     * @param userId
     * @return
     */
    BuildingInfo selectBuildById(Long userId);

    /**
     * 查询户主信息列表
     * @param queryUserInfo
     * @return
     */
    List<QueryUserInfo> queryAllUserInfo(QueryUserInfo queryUserInfo);

    /**
     * 查询所有的房屋类型
     * @return
     */
    List<BuildingType> selectAllType();
}
