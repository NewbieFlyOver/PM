package com.pm.dsis.fee.mapper;


import com.pm.dsis.fee.dto.PmFee;

import java.util.List;

public interface PmFeeMapper {

    /**
     * 查询满足交物业费房屋的类型及当月单价
     * @return
     */
    List<PmFee> selectPriceAndType();

    /**
     * 添加物业费
     * @param pmFee
     * @return
     */
    int insert(PmFee pmFee);



    int deleteByPrimaryKey(Long pmId);



    int insertSelective(PmFee record);

    PmFee selectByPrimaryKey(Long pmId);

    int updateByPrimaryKeySelective(PmFee record);

    int updateByPrimaryKey(PmFee record);
}