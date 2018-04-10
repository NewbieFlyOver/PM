package com.pm.dsis.gs.service;

import com.pm.dsis.gs.dto.GarageState;

import java.util.List;

/**
 * Created by admin on 2018/4/9.
 */
public interface GarageStateService {

    /**
     * 查询所有的车位
     * @return
     */
    List<GarageState> selectGarageState(GarageState garageState);

    /**
     * 保存
     * @param garageState
     * @return
     */
    void insertGarageState(GarageState garageState);


    /**
     * 更新状态至空闲
     * @param record
     * @return
     */
    int updateByGsId(GarageState record);

}
