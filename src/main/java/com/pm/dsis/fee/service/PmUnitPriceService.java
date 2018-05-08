package com.pm.dsis.fee.service;

import com.pm.dsis.fee.dto.PmUnitPrice;

import java.util.List;

/**
 * Created by admin on 2018/5/8.
 */
public interface PmUnitPriceService {
    /**
     * 更新物业费单价
     * @param pmUnitPrices
     * @return
     */
    void updatePmUnitPriceById(List<PmUnitPrice> pmUnitPrices);

    /**
     * 查询所有物业单价
     * @return
     */
    List<PmUnitPrice> selectPmUnitPrice ();
}
