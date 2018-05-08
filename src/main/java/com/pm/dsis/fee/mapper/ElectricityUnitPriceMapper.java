package com.pm.dsis.fee.mapper;


import java.util.List;

import com.pm.dsis.fee.dto.ElectricityUnitPrice;
import org.apache.ibatis.annotations.Param;

public interface ElectricityUnitPriceMapper {

    /**
     * 查询所有的阶梯电价
     * @return
     */
    List<ElectricityUnitPrice> selectAllelectPrice();


    /**
     * 添加电价
     * @param electricityUnitPrice
     * @return
     */
    int insertElectUnitPrice(ElectricityUnitPrice electricityUnitPrice);


    /**
     * 更新电价
     * @param electricityUnitPrice
     * @return
     */
    int updateElectUnitPriceById(ElectricityUnitPrice electricityUnitPrice);

    /**
     * 删除电价
     * @param electricityUnitPrice
     * @return
     */
    int deleteElectUnitPriceById(ElectricityUnitPrice electricityUnitPrice);





    int deleteByPrimaryKey(Long eaUrId);

    int insertSelective(ElectricityUnitPrice record);

    ElectricityUnitPrice selectByPrimaryKey(Long eaUrId);

    int updateByPrimaryKeySelective(ElectricityUnitPrice record);
}