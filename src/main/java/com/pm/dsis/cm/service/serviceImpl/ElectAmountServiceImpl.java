package com.pm.dsis.cm.service.serviceImpl;

import com.pm.dsis.cm.dto.ElectricityAmount;
import com.pm.dsis.cm.mapper.ElectricityAmountMapper;
import com.pm.dsis.cm.service.ElectAmountService;
import com.pm.dsis.fee.dto.ElectricityUnitPrice;
import com.pm.dsis.fee.mapper.ElectricityUnitPriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2018/3/25.
 */
@Service
public class ElectAmountServiceImpl implements ElectAmountService {

    @Autowired
    private ElectricityAmountMapper electricityAmountMapper;

    @Autowired
    private ElectricityUnitPriceMapper electricityUnitPriceMapper;

    public void insertElect(List<ElectricityAmount> electricityAmounts){
        for(ElectricityAmount ea: electricityAmounts) {
            //获取本月用量
            int month = ea.getEaMonth()-1;
            ElectricityAmount electricityAmount = electricityAmountMapper.selectByRoomMonth(month,ea.getBuildingFullRoom());
            if ( electricityAmount ==null ) {
                ea.setEaDosage(electricityAmount.getEaNumber());
            }else{
                ea.setEaDosage(ea.getEaNumber()-electricityAmount.getEaNumber());
            }
            //根据本月用量计算本月费用
            //获取水价阶梯
            List<ElectricityUnitPrice> electricityUnitPrices = electricityUnitPriceMapper.selectAllelectPrice();
            float tempElect = ea.getEaDosage();
            float electSum = 0L;
            for (ElectricityUnitPrice eup:electricityUnitPrices) {
                //TODO:超过最大值处理
                if (tempElect>eup.getEaUrLower() || tempElect ==eup.getEaUrLower() ) {
                    float temp = eup.getEaUrPrice() * (tempElect - eup.getEaUrLower());
                    electSum = electSum + temp;
                    tempElect = tempElect - eup.getEaUrLower();
                }
            }
            if (ea.getEaId() == null) {
                electricityAmountMapper.insertElect(ea);
            }else {
                electricityAmountMapper.updateElectById(ea);
            }
        }
    }

    public List<ElectricityAmount> selectByMonth(int month ){
        return electricityAmountMapper.selectByMonth(month);
    }

    public void deleteByEAId( List<ElectricityAmount> electricityAmounts){
        for (ElectricityAmount ea: electricityAmounts) {
            electricityAmountMapper.deleteByEAId(ea.getEaId());
        }
    }
}
