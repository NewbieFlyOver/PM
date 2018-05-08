package com.pm.dsis.fee.service;

import com.pm.dsis.fee.dto.WaterUnitPrice;

import java.util.List;

/**
 * Created by admin on 2018/5/8.
 */
public interface WaterUnitPriceService {

    /**
     * 更改或添加水价
     * @param waterUnitPrices
     * @return
     */
    void updateWaterUnitPriceById(List<WaterUnitPrice> waterUnitPrices);


    /**
     * 删除水价
     * @param waterUnitPrices
     * @return
     */
    void deleteWaterUnitPriceById(List<WaterUnitPrice> waterUnitPrices);

    /**
     * 查询所有水价
     * @return
     */
    List<WaterUnitPrice> selectAllWaterPrice();

}
