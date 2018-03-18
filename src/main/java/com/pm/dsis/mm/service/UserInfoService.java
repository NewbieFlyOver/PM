package com.pm.dsis.mm.service;

import com.pm.dsis.mm.dto.UserInfo;
import com.pm.dsis.mm.dto.UserMember;

import java.util.List;

/**
 * Created by admin on 2018/3/18.
 */
public interface UserInfoService {
    /**
     * 添加户主信息
     * @param userInfo
     * @return
     */
    int insertUserInfo(UserInfo userInfo);

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
     * 根据id删除常住人员的信息
     * @param memberId
     * @return
     */
    void deleteById(List<UserMember> userMemberList);
}
