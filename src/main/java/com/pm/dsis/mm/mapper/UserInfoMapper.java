package com.pm.dsis.mm.mapper;

import com.pm.dsis.mm.dto.UserInfo;

/**
 * Created by admin on 2018/3/18.
 */
public interface UserInfoMapper {

    /**
     * 添加业主信息
     * @param userInfo
     * @return
     */
    int insertUserInfo(UserInfo userInfo);

    Long queryUserId();

    /**
     * 通过户主id查找户主基本信息
     * @param userId
     * @return
     */
    UserInfo selectByUserId(Long userId);

    /**
     * 更新户主基本信息
     * @param userInfo
     * @return
     */
    int updateByUserId(UserInfo userInfo);

    /**
     * 根据条件查询为激活的新用户
     * @param userInfo
     * @return
     */
    UserInfo selectActiveUserInfo(UserInfo userInfo);

    /**
     * 是否激活
     * @param userInfo
     * @return
     */
    UserInfo active(UserInfo userInfo);

    /**
     * 查询登录信息
     * @param userInfo
     * @return
     */
    UserInfo selectLoginUserInfo(UserInfo userInfo);

    /**
     * 查询账号是否存在
     * @param userAccount
     * @return
     */
    UserInfo selectAccount(String userAccount);



}
