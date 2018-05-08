package com.pm.dsis.fee.mapper;


import java.util.List;

import com.pm.dsis.fee.dto.PmUnitPrice;
import org.apache.ibatis.annotations.Param;

public interface PmUnitPriceMapper {


    /**
     * 查询所有物业单价
     * @return
     */
    List<PmUnitPrice> selectPmUnitPrice ();

    /**
     * 增加物业费单价
     * @param pmUnitPrice
     * @return
     */
    int insertPmUnitPrice(PmUnitPrice pmUnitPrice);

    /**
     * 更新物业费单价
     * @param pmUnitPrice
     * @return
     */
    int updatePmUnitPriceById(PmUnitPrice pmUnitPrice);

    /**
     * 删除物业费单价
     * @param pmUnitPrice
     * @return
     */
    int deletePmUnitPriceById(PmUnitPrice pmUnitPrice);





    int deleteByPrimaryKey(Long pmUpId);

    int insertSelective(PmUnitPrice record);

    PmUnitPrice selectByPrimaryKey(Long pmUpId);

    int updateByPrimaryKeySelective(PmUnitPrice record);

    int updateByPrimaryKey(PmUnitPrice record);
}