package com.pm.dsis.fee.service;

import com.pm.dsis.fee.dto.ElectricityUnitPrice;

import java.util.List;

/**
 * Created by admin on 2018/5/8.
 */
public interface ElectUnitPriceService {

    /**
     * 查询所有的阶梯电价
     * @return
     */
    List<ElectricityUnitPrice> selectAllelectPrice();

    /**
     * 更新或添加电价
     * @param electricityUnitPrices
     * @return
     */
    void updateElectUnitPriceById(List<ElectricityUnitPrice> electricityUnitPrices);

    /**
     * 删除电价
     * @param electricityUnitPrices
     * @return
     */
    void deleteElectUnitPriceById(List<ElectricityUnitPrice> electricityUnitPrices);



}
