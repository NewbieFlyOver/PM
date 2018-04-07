package com.pm.dsis.cm.service;

import com.pm.dsis.cm.dto.ElectricityAmount;

import java.util.List;

/**
 * Created by admin on 2018/3/25.
 */
public interface ElectAmountService {

    /**
     * 批量添加/更新用电量
     * @param electricityAmounts
     */
    void insertElect(List<ElectricityAmount> electricityAmounts);

    /**
     * 根据月份查询用电量
     * @param month
     * @return
     */
    List<ElectricityAmount> selectByMonth(int month );

    /**
     * 批量删除
     * @param electricityAmounts
     * @return
     */
    void deleteByEAId( List<ElectricityAmount> electricityAmounts);

    //条件查询
    List<ElectricityAmount> selectElect(ElectricityAmount electricityAmount);

    //更新电费是否已交
    void updateElectStatu(List<ElectricityAmount> electricityAmounts);
}
