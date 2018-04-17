package com.pm.dsis.em.service;

import com.pm.dsis.em.dto.HousekeeperBuildingInfo;

/**
 * Created by admin on 2018/4/15.
 */
public interface HousekeeperBuildingInfoService {

    /**
     * 添加员工信息
     * @param housekeeperBuildingInfo
     * @return
     */
    void insertHouseInfo(HousekeeperBuildingInfo housekeeperBuildingInfo);

    /**
     * 更新员工信息
     * @param housekeeperBuildingInfo
     * @return
     */
    int updateHouseInfoById(HousekeeperBuildingInfo housekeeperBuildingInfo);

    /**
     * 根据id查询员工信息
     * @param hbId
     * @return
     */
    HousekeeperBuildingInfo selectHouseInfoById(Long hbId);



}
