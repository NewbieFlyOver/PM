package com.pm.dsis.em.service.serviceImpl;

import com.pm.dsis.em.dto.HousekeeperBuildingInfo;
import com.pm.dsis.em.mapper.HousekeeperBuildingInfoMapper;
import com.pm.dsis.em.service.HousekeeperBuildingInfoService;
import com.pm.dsis.lr.service.ServiceImpl.LrServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2018/4/15.
 */
@Service
public class HousekeeperBuildingInfoServiceImpl implements HousekeeperBuildingInfoService{

    @Autowired
    private HousekeeperBuildingInfoMapper housekeeperBuildingInfoMapper;



    public void insertHouseInfo(HousekeeperBuildingInfo housekeeperBuildingInfo) throws Exception{

        if( null == housekeeperBuildingInfo.getHbId() ) {
            Long bigNumber = housekeeperBuildingInfoMapper.selectBigNumber()+1;
            housekeeperBuildingInfo.setHbNumber(bigNumber);
            housekeeperBuildingInfo.setHbPassword(LrServiceImpl.getMD5("123456"));

            String dateStr = housekeeperBuildingInfo.getHbInductionDateStr().substring(0,10);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(dateStr);
            housekeeperBuildingInfo.setHbInductionDate(date);

            housekeeperBuildingInfoMapper.insertHouseInfo(housekeeperBuildingInfo);
        } else {
            housekeeperBuildingInfoMapper.updateHouseInfoById(housekeeperBuildingInfo);
        }
    }


    public int updateHouseInfoById(HousekeeperBuildingInfo housekeeperBuildingInfo){
        return housekeeperBuildingInfoMapper.updateHouseInfoById(housekeeperBuildingInfo);
    }


    public HousekeeperBuildingInfo selectHouseInfoById(Long hbId){

        HousekeeperBuildingInfo hbi= housekeeperBuildingInfoMapper.selectHouseInfoById(hbId);
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String hbInductionStr = sdf.format(hbi.getHbInductionDate());
        hbi.setHbInductionDateStr(hbInductionStr);
        return hbi;
    }

    public List<HousekeeperBuildingInfo> selectHbByCondtion(HousekeeperBuildingInfo hb){
        return housekeeperBuildingInfoMapper.selectHbByCondtion(hb);
    }

}
