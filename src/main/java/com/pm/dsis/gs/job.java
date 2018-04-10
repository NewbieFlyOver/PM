package com.pm.dsis.gs;

import com.pm.dsis.gs.dto.GarageState;
import com.pm.dsis.gs.service.GarageStateService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2018/4/10.
 */
public class job {

    @Autowired
    private GarageStateService garageStateService;

    public void updateGsStatu() {
        GarageState garageState = new GarageState();
        List<GarageState> garageStates = garageStateService.selectGarageState(garageState);
        Date nowDate = new Date();
        for (GarageState gs : garageStates) {
            Date endDate = gs.getVfEndDate();
            if( endDate.getTime() > nowDate.getTime() || endDate == nowDate && gs.getGsState().equals("takeUp")) {
                Date date = new Date();
                gs.setVfBigenDate(date);
                gs.setVfEndDate(date);
                garageStateService.updateByGsId(gs);
            }
        }
    }
}
