package com.pm.dsis.fee.mapper;


import java.util.List;

import com.pm.dsis.fee.dto.PmUnitPrice;
import org.apache.ibatis.annotations.Param;

public interface PmUnitPriceMapper {

    int deleteByPrimaryKey(Long pmUpId);

    int insert(PmUnitPrice record);

    int insertSelective(PmUnitPrice record);

    PmUnitPrice selectByPrimaryKey(Long pmUpId);

    int updateByPrimaryKeySelective(PmUnitPrice record);

    int updateByPrimaryKey(PmUnitPrice record);
}