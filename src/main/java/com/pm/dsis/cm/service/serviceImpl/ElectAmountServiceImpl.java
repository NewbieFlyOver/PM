package com.pm.dsis.cm.service.serviceImpl;

import com.pm.dsis.cm.dto.ElectricityAmount;
import com.pm.dsis.cm.mapper.ElectricityAmountMapper;
import com.pm.dsis.cm.service.ElectAmountService;
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

    public void insertElect(List<ElectricityAmount> electricityAmounts){
        for(ElectricityAmount ea: electricityAmounts) {
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
