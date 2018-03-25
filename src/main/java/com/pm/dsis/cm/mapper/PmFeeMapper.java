package com.pm.dsis.cm.mapper;


import java.util.List;

import com.pm.dsis.cm.dto.PmFee;
import org.apache.ibatis.annotations.Param;

public interface PmFeeMapper {

    int deleteByPrimaryKey(Long pmId);

    int insert(PmFee record);

    int insertSelective(PmFee record);

    PmFee selectByPrimaryKey(Long pmId);

    int updateByPrimaryKeySelective(PmFee record);

    int updateByPrimaryKey(PmFee record);
}