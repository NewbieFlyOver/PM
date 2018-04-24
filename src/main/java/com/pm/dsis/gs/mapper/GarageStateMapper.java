package com.pm.dsis.gs.mapper;

import java.util.List;

import com.pm.dsis.gs.dto.GarageState;
import org.apache.ibatis.annotations.Param;

public interface GarageStateMapper {

    /**
     * 查询所有的车位
     * @return
     */
    List<GarageState> selectGarageState(GarageState garageState);


    /**
     * 根据userId查询车位
     * @return
     */
    List<GarageState> selectGarageStateByUserId(GarageState garageState);


    /**
     * 保存
     * @param garageState
     * @return
     */
    int insertGarageState(GarageState garageState);

    /**
     * 更新状态至空闲
     * @param record
     * @return
     */
    int updateByGsId(GarageState record);





    int deleteByPrimaryKey(Long gsId);

    int insert(GarageState record);

    int insertSelective(GarageState record);

    GarageState selectByPrimaryKey(Long gsId);

    int updateByPrimaryKeySelective(GarageState record);

    int updateByPrimaryKey(GarageState record);
}