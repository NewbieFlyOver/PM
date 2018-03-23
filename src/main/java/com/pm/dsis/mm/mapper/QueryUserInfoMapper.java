package com.pm.dsis.mm.mapper;

import com.pm.dsis.mm.dto.QueryUserInfo;

import java.util.List;

/**
 * Created by admin on 2018/3/23.
 */
public interface QueryUserInfoMapper {

    List<QueryUserInfo> queryAllUserInfo(QueryUserInfo queryUserInfo);


}
