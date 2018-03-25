package com.pm.dsis.fee.service;

import com.pm.dsis.cm.dto.WaterAmount;
import com.pm.dsis.fee.dto.WaterUnitPrice;

import java.util.List;

/**
 * Created by admin on 2018/3/25.
 */
public interface CostManagService {

    /**
     * 查询所有水价
     * @return
     */
    List<WaterAmount> selectAllWaterFee();
}
