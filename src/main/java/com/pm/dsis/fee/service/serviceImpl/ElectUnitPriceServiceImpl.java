package com.pm.dsis.fee.service.serviceImpl;

import com.pm.dsis.fee.dto.ElectricityUnitPrice;
import com.pm.dsis.fee.mapper.ElectricityUnitPriceMapper;
import com.pm.dsis.fee.service.ElectUnitPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2018/5/8.
 */
@Service
public class ElectUnitPriceServiceImpl implements ElectUnitPriceService {

    @Autowired
    private ElectricityUnitPriceMapper electricityUnitPriceMapper;

    /**
     * 查询所有的阶梯电价
     * @return
     */
    public List<ElectricityUnitPrice> selectAllelectPrice() {
        return electricityUnitPriceMapper.selectAllelectPrice();
    }


    /**
     * 更新或添加电价
     * @param electricityUnitPrices
     * @return
     */
    public void updateElectUnitPriceById(List<ElectricityUnitPrice> electricityUnitPrices) {
        for (ElectricityUnitPrice eup: electricityUnitPrices) {
            if (eup.getEaUrId() == null) {
                electricityUnitPriceMapper.insertElectUnitPrice(eup);
            } else {
                electricityUnitPriceMapper.updateElectUnitPriceById(eup);
            }
        }
    }

    /**
     * 删除电价
     * @param electricityUnitPrices
     * @return
     */
    public void deleteElectUnitPriceById(List<ElectricityUnitPrice> electricityUnitPrices) {
        for (ElectricityUnitPrice eup: electricityUnitPrices) {
            electricityUnitPriceMapper.deleteElectUnitPriceById(eup);
        }
    }



}
