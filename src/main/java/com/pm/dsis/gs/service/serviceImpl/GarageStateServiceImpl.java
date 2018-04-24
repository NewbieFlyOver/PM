package com.pm.dsis.gs.service.serviceImpl;

import com.pm.dsis.gs.dto.GarageState;
import com.pm.dsis.gs.mapper.GarageStateMapper;
import com.pm.dsis.gs.service.GarageStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by admin on 2018/4/9.
 */
@Service
public class GarageStateServiceImpl implements GarageStateService {


    @Autowired
    private GarageStateMapper garageStateMapper;

    public List<GarageState> selectGarageState(GarageState garageState){
        List<GarageState> garageStateList = garageStateMapper.selectGarageState(garageState);
        for (GarageState gs: garageStateList) {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String bigenDateStr = sdf.format(gs.getVfBigenDate());
            String endDateStr = sdf.format(gs.getVfEndDate());
            gs.setVfBigenDateStr(bigenDateStr);
            gs.setVfEndDateStr(endDateStr);
        }

        return garageStateList;
    }

    /**
     * 根据userId查询车位
     * @return
     */
    public List<GarageState> selectGarageStateByUserId(GarageState garageState) {
        List<GarageState> garageStateList = garageStateMapper.selectGarageState(garageState);
        for (GarageState gs: garageStateList) {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String bigenDateStr = sdf.format(gs.getVfBigenDate());
            String endDateStr = sdf.format(gs.getVfEndDate());
            gs.setVfBigenDateStr(bigenDateStr);
            gs.setVfEndDateStr(endDateStr);
        }

        return garageStateList;
    }

    public void insertGarageState(GarageState garageStates){
       // for (GarageState gs: garageStates) {
            garageStateMapper.insertGarageState(garageStates);
        //}

    }

    public int updateByGsId(GarageState record) {
        return garageStateMapper.updateByGsId(record);
    }

}
