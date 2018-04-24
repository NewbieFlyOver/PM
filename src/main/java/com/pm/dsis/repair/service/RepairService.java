package com.pm.dsis.repair.service;

import com.pm.dsis.repair.dto.RepairInfo;

import java.util.List;

/**
 * Created by admin on 2018/4/24.
 */
public interface RepairService {


    /**
     * 保存报修信息
     * @param record
     * @return
     */
    int insertRepairInfo(RepairInfo record);

    /**
     * 条件查询
     * @param repairInfo
     * @return
     */
    List<RepairInfo> selectRepairInfo(RepairInfo repairInfo);


}
