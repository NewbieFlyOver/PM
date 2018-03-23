package com.pm.dsis.mm.mapper;

import com.pm.dsis.mm.dto.BuildingInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuildingInfoMapper {

    int insertBuildingInfo(BuildingInfo buildingInfo);

    BuildingInfo selectBuildById(Long userId);

    /**
     * 根据房屋id进行更新
     * @param buildingInfo
     * @return
     */
    int updateByBuildId(BuildingInfo buildingInfo);



    int deleteByPrimaryKey(Long buildingId);



    int insertSelective(BuildingInfo record);

    int updateByPrimaryKeySelective(BuildingInfo record);


}