package com.pm.dsis.mm.mapper;

import com.pm.dsis.mm.dto.UserInfo;
import org.apache.ibatis.annotations.Param;

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
     * 查询登录信息通过电话
     * @return
     */
    UserInfo selectAccountByPhone(@Param("phone") String phone, @Param("account") String account);
    /**
     * 查询账号是否存在
     * @param userAccount
     * @return
     */
    UserInfo selectAccount(String userAccount);

    /**
     * 重置密码
     * @param userId
     * @param oldPwd
     * @param newPwd
     * @return
     */
    int resetPwd(@Param("userId") Long userId, @Param("oldPwd") String oldPwd, @Param("newPwd") String newPwd);


    /**
     * 根据登录名更改密码
     * @param account
     * @return
     */
    int updateByAccount(@Param("account") String account, @Param("newPwd") String newPwd);
}
