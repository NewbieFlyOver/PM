package com.pm.dsis.repair.mapper;


import java.util.List;

import com.pm.dsis.repair.dto.RepairInfo;
import org.apache.ibatis.annotations.Param;

public interface RepairInfoMapper {

    int deleteByPrimaryKey(Long riId);

    int insert(RepairInfo record);

    int insertSelective(RepairInfo record);

    RepairInfo selectByPrimaryKey(Long riId);

    int updateByPrimaryKeySelective(RepairInfo record);

    int updateByPrimaryKey(RepairInfo record);
}