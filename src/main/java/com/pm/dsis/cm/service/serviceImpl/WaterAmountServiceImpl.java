package com.pm.dsis.cm.service.serviceImpl;

import com.pm.dsis.cm.dto.WaterAmount;
import com.pm.dsis.cm.mapper.WaterAmountMapper;
import com.pm.dsis.cm.service.WaterAmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by admin on 2018/3/25.
 */
@Service
public class WaterAmountServiceImpl implements WaterAmountService {

    @Autowired
    private WaterAmountMapper waterAmountMapper;

    public void insertWaterAmount(List<WaterAmount> waterAmounts){
        for (WaterAmount wat:waterAmounts) {
            if(null == wat.getWaId()){
                waterAmountMapper.insertWaterAmount(wat);
            }else {
                waterAmountMapper.updateByWaterAId(wat);
            }

        }
    }

    public void updateByWaterAId(List<WaterAmount> waterAmounts){
        for (WaterAmount wa:waterAmounts) {
            waterAmountMapper.updateByWaterAId(wa);
        }

    }
    public void deleteByWaterAId(List<WaterAmount> waterAmounts){
        for (WaterAmount wa:waterAmounts) {
            waterAmountMapper.deleteByWaterAId(wa.getWaId());
        }
    }

    public List<WaterAmount> selectWaterAByMonth(int month){
        return waterAmountMapper.selectWaterAByMonth(month);
    }

}
