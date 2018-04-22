package com.pm.dsis.cm.mapper;


import java.util.List;

import com.pm.dsis.cm.dto.ElectricityAmount;
import org.apache.ibatis.annotations.Param;

public interface ElectricityAmountMapper {

    int insertElect(ElectricityAmount electricityAmount);

    int updateElectById(ElectricityAmount record);

    List<ElectricityAmount> selectByMonth(int month );

    int deleteByEAId(Long eaId);

    // 查询上一个月指定用户的读数
    ElectricityAmount selectByRoomMonth(@Param("eaMonth") int waMonth, @Param("buildingFullRoom") String buildingFullRoom);


    //条件查询
    List<ElectricityAmount> selectElect(ElectricityAmount electricityAmount);

    /**
     * 查询根据userId查询
     */
    List<ElectricityAmount> selectElectByUserId(ElectricityAmount electricityAmount);

    //更新电费是否已交
    int updateElectStatu(ElectricityAmount electricityAmount);



    int insertSelective(ElectricityAmount record);

    ElectricityAmount selectByPrimaryKey(Long eaId);

    int updateByPrimaryKeySelective(ElectricityAmount record);

    int updateByPrimaryKey(ElectricityAmount record);
}