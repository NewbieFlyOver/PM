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
}
