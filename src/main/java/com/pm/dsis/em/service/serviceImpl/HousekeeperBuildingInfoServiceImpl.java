package com.pm.dsis.em.service.serviceImpl;

import com.pm.dsis.em.dto.HousekeeperBuildingInfo;
import com.pm.dsis.em.mapper.HousekeeperBuildingInfoMapper;
import com.pm.dsis.em.service.HousekeeperBuildingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2018/4/15.
 */
@Service
public class HousekeeperBuildingInfoServiceImpl implements HousekeeperBuildingInfoService{

    @Autowired
    private HousekeeperBuildingInfoMapper housekeeperBuildingInfoMapper;



    public void insertHouseInfo(HousekeeperBuildingInfo housekeeperBuildingInfo){

        if( null == housekeeperBuildingInfo.getHbId() ) {
            housekeeperBuildingInfoMapper.insertHouseInfo(housekeeperBuildingInfo);
        } else {
            housekeeperBuildingInfoMapper.updateHouseInfoById(housekeeperBuildingInfo);
        }
    }


    public int updateHouseInfoById(HousekeeperBuildingInfo housekeeperBuildingInfo){
        return housekeeperBuildingInfoMapper.updateHouseInfoById(housekeeperBuildingInfo);
    }


    public HousekeeperBuildingInfo selectHouseInfoById(Long hbId){
        return housekeeperBuildingInfoMapper.selectHouseInfoById(hbId);
    }

    public List<HousekeeperBuildingInfo> selectHbByCondtion(HousekeeperBuildingInfo hb){
        return housekeeperBuildingInfoMapper.selectHbByCondtion(hb);
    }

}
