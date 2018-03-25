package com.pm.dsis.fee.mapper;

import com.pm.dsis.fee.dto.WaterUnitPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WaterUnitPriceMapper {
    /**
     * 查询所有水价
     * @return
     */
    List<WaterUnitPrice> selectAllWaterPrice();





    int deleteByPrimaryKey(Long waUrId);

    int insert(WaterUnitPrice record);

    int insertSelective(WaterUnitPrice record);

    WaterUnitPrice selectByPrimaryKey(Long waUrId);

    int updateByPrimaryKeySelective(WaterUnitPrice record);

    int updateByPrimaryKey(WaterUnitPrice record);
}