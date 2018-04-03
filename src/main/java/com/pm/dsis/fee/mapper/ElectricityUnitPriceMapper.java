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






    int deleteByPrimaryKey(Long eaUrId);

    int insert(ElectricityUnitPrice record);

    int insertSelective(ElectricityUnitPrice record);

    ElectricityUnitPrice selectByPrimaryKey(Long eaUrId);

    int updateByPrimaryKeySelective(ElectricityUnitPrice record);

    int updateByPrimaryKey(ElectricityUnitPrice record);
}