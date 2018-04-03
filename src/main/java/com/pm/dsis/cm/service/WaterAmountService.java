package com.pm.dsis.cm.service;

import com.pm.dsis.cm.dto.WaterAmount;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by admin on 2018/3/25.
 */
public interface WaterAmountService {

    /**
     * 批量添加/更新用水量
     * @param waterAmounts
     */
    void insertWaterAmount(List<WaterAmount> waterAmounts);

    /**
     * 批量更新用水量
     * @param waterAmounts
     */
    void updateByWaterAId(List<WaterAmount> waterAmounts);

    /**
     * 批量删除用水量
     * @param waterAmounts
     */
    void deleteByWaterAId(List<WaterAmount> waterAmounts);

    /**
     * 根据月份查询用水量
     * @param month
     * @return
     */
    List<WaterAmount> selectWaterAByMonth(int month);

    /**
     * 根据月份和房号查询水量
     * @param waMonth
     * @param buildingFullRoom
     * @return
     */
    WaterAmount selectByRoomMonth(int waMonth,String buildingFullRoom);

}
