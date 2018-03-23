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

}
