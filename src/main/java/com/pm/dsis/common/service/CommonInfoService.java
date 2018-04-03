package com.pm.dsis.common.service;

import com.pm.dsis.common.dto.CommonInfo;

import java.util.List;

/**
 * Created by admin on 2018/4/2.
 */
public interface CommonInfoService {

    /**
     * 根据通用类型查询通用信息
     * @param commonType
     * @return
     */
    List<CommonInfo> selectByType(String commonType);


}
