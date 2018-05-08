package com.pm.dsis.fee.service.serviceImpl;

import com.pm.dsis.fee.dto.PmUnitPrice;
import com.pm.dsis.fee.mapper.PmUnitPriceMapper;
import com.pm.dsis.fee.service.PmUnitPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2018/5/8.
 */
@Service
public class PmUnitPriceServiceImpl implements PmUnitPriceService {

    @Autowired
    private PmUnitPriceMapper pmUnitPriceMapper;

    /**
     * 更新物业费单价
     * @param pmUnitPrices
     * @return
     */
    public void updatePmUnitPriceById(List<PmUnitPrice> pmUnitPrices) {

        for (PmUnitPrice pup : pmUnitPrices) {
            pmUnitPriceMapper.updatePmUnitPriceById(pup);
        }
    }

    /**
     * 查询所有物业单价
     * @return
     */
    public List<PmUnitPrice> selectPmUnitPrice () {
        return pmUnitPriceMapper.selectPmUnitPrice();
    }

}
