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

    /**
     * 增加水价
     * @param waterUnitPrice
     * @return
     */
    int insertWaterUnitPrice(WaterUnitPrice waterUnitPrice);

    /**
     * 更改水价
     * @param waterUnitPrice
     * @return
     */
    int updateWaterUnitPriceById(WaterUnitPrice waterUnitPrice);

    /**
     * 删除水价
     * @param waterUnitPrice
     * @return
     */
    int deleteWaterUnitPriceById(WaterUnitPrice waterUnitPrice);





    int insertSelective(WaterUnitPrice record);

    WaterUnitPrice selectByPrimaryKey(Long waUrId);

    int updateByPrimaryKeySelective(WaterUnitPrice record);

}