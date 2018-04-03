package com.pm.dsis.cm.service.serviceImpl;

import com.pm.dsis.cm.dto.WaterAmount;
import com.pm.dsis.cm.mapper.WaterAmountMapper;
import com.pm.dsis.cm.service.WaterAmountService;
import com.pm.dsis.fee.dto.WaterUnitPrice;
import com.pm.dsis.fee.mapper.WaterUnitPriceMapper;
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
    @Autowired
    private WaterUnitPriceMapper waterUnitPriceMapper;

    public void insertWaterAmount(List<WaterAmount> waterAmounts){
        for (WaterAmount wat:waterAmounts) {
            //添加本月用量
            int month = wat.getWaMonth()-1;
            WaterAmount waterAmount = selectByRoomMonth(month,wat.getBuildingFullRoom());
            if (waterAmount == null) {
                wat.setWaDosage(wat.getWaNumber());
            }else {
                wat.setWaDosage(wat.getWaNumber() - waterAmount.getWaNumber());
            }
            //TODO：根据本月用量计算本月费用
            //获取水价阶梯
            List<WaterUnitPrice> waterUnitPrices = waterUnitPriceMapper.selectAllWaterPrice();
            float tempWater = wat.getWaDosage();
            float waterSum = 0L;
            for (WaterUnitPrice wup:waterUnitPrices ) {
                //TODO:超过最大值处理
                if ( tempWater>wup.getWaUrLower() || tempWater == wup.getWaUrLower()) {
                    float temp = wup.getWaUrPrice()*(tempWater-wup.getWaUrLower());
                    waterSum = waterSum + temp;
                    tempWater = tempWater - wup.getWaUrLower();
                }
            }
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

    public WaterAmount selectByRoomMonth(int waMonth,String buildingFullRoom){
        return waterAmountMapper.selectByRoomMonth(waMonth,buildingFullRoom);
    }

}
