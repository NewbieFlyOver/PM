package com.pm.dsis.mm.mapper;

import java.util.List;

import com.pm.dsis.mm.dto.BuildingType;
import org.apache.ibatis.annotations.Param;

public interface BuildingTypeMapper {
    /**
     *
     * 查询有的房屋类型
     * @return
     */
    List<BuildingType> selectAllType();





    int deleteByPrimaryKey(Long buildingTypeId);

    int insert(BuildingType record);

    int insertSelective(BuildingType record);

    BuildingType selectByPrimaryKey(Long buildingTypeId);

    int updateByPrimaryKeySelective(BuildingType record);

    int updateByPrimaryKey(BuildingType record);
}