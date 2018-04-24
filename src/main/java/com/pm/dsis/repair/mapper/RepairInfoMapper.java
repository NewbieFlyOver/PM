package com.pm.dsis.repair.mapper;


import java.util.List;

import com.pm.dsis.repair.dto.RepairInfo;
import org.apache.ibatis.annotations.Param;

public interface RepairInfoMapper {

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
    //todo:只有userId
    List<RepairInfo> selectRepairInfo(RepairInfo repairInfo);




    int deleteByPrimaryKey(Long riId);

    int insert(RepairInfo record);

    int insertSelective(RepairInfo record);

    RepairInfo selectByPrimaryKey(Long riId);

    int updateByPrimaryKeySelective(RepairInfo record);

    int updateByPrimaryKey(RepairInfo record);
}