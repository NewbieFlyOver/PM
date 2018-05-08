package com.pm.dsis.fee.service.serviceImpl;

import com.pm.dsis.fee.dto.WaterUnitPrice;
import com.pm.dsis.fee.mapper.WaterUnitPriceMapper;
import com.pm.dsis.fee.service.WaterUnitPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2018/5/8.
 */
@Service
public class WaterUnitPriceServiceImpl implements WaterUnitPriceService {

    @Autowired
    private WaterUnitPriceMapper waterUnitPriceMapper;


    /**
     * 更改或添加水价
     * @param waterUnitPrices
     * @return
     */
    public void updateWaterUnitPriceById(List<WaterUnitPrice> waterUnitPrices) {

        for(WaterUnitPrice wup: waterUnitPrices) {
            if(wup.getWaUrId() == null) {
                waterUnitPriceMapper.insertWaterUnitPrice(wup);
            }else {
                waterUnitPriceMapper.updateWaterUnitPriceById(wup);
            }
        }
    }

    /**
     * 删除水价
     * @param waterUnitPrices
     * @return
     */
    public void deleteWaterUnitPriceById(List<WaterUnitPrice> waterUnitPrices) {
        for(WaterUnitPrice wup: waterUnitPrices) {
            waterUnitPriceMapper.deleteWaterUnitPriceById(wup);
        }
    }

    /**
     * 查询所有水价
     * @return
     */
    public List<WaterUnitPrice> selectAllWaterPrice() {
        return waterUnitPriceMapper.selectAllWaterPrice();
    }

}
