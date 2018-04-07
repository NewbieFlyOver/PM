package com.pm.dsis.cm.service.serviceImpl;

import com.pm.dsis.cm.dto.WaterAmount;
import com.pm.dsis.cm.mapper.WaterAmountMapper;
import com.pm.dsis.cm.service.WaterAmountService;
import com.pm.dsis.fee.dto.WaterUnitPrice;
import com.pm.dsis.fee.mapper.WaterUnitPriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            if (null == wat.getWaId()) {
                //时间类型转换
                Date date = wat.getWaBigenDate();
                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dateStr = sdf.format(date);

                String yearStr = dateStr.substring(0,dateStr.length()-6);
                String monthStr = dateStr.substring(5,7);

                int yearInt = Integer.parseInt(yearStr);
                int monthInt = Integer.parseInt(monthStr);

                wat.setWaMonth(Integer.parseInt(dateStr.substring(0,dateStr.length()-6)+dateStr.substring(5,7)));

                String month = "";
                if (monthInt<12&&monthInt>9) {
                    yearStr = Integer.toString(yearInt -1) ;
                    month = yearStr+monthStr;
                }else {
                    monthStr = Integer.toString(monthInt-1);
                    if (monthInt<10) {
                        month = yearStr+"0"+monthStr;
                    }
                }
                int monthPara = Integer.parseInt(month);
                WaterAmount waterAmount = selectByRoomMonth(monthPara,wat.getBuildingFullRoom());
                //todo:加个判断
                //添加本月用量
                if (waterAmount == null) {
                    wat.setWaDosage(wat.getWaNumber());
                }else {
                    wat.setWaDosage(wat.getWaNumber() - waterAmount.getWaNumber());
                }

                //获取水价阶梯
                List<WaterUnitPrice> waterUnitPrices = waterUnitPriceMapper.selectAllWaterPrice();
                float tempWater = wat.getWaDosage();
                float waterSum = 0L;
                //根据本月用量计算本月费用
                for (WaterUnitPrice wup:waterUnitPrices ) {
                    //超过最大值处理
                    if ( tempWater>wup.getWaUrLower() || tempWater == wup.getWaUrLower()) {
                        float temp = wup.getWaUrPrice()*(tempWater-wup.getWaUrLower());
                        waterSum = waterSum + temp;
                        tempWater = tempWater - wup.getWaUrLower();
                     }
                }
                wat.setMonthFee(waterSum);

                WaterAmount watAmount = selectByRoomMonth(wat.getWaMonth(),wat.getBuildingFullRoom());
                if(null == wat.getWaId()){
                    waterAmountMapper.insertWaterAmount(wat);
                } else {
                    System.out.println("此月数据已存在！");
                }
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

    /**
     * 根据条件查询
     * @return
     */
    public List<WaterAmount> selectWater(WaterAmount waterAmount){
        /*if (waterAmount.getWaFlag() == null) {
            waterAmount.setWaFlag("N");
        }*/
        List<WaterAmount> waterAmountList = waterAmountMapper.selectWater(waterAmount);
        //时间类型转换
        for ( WaterAmount wa : waterAmountList ) {
       // Date date = wa.getWaBigenDate();
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String bigenDateStr = sdf.format(wa.getWaBigenDate());
            String endDateStr = sdf.format(wa.getWaEndDate());
            wa.setWaBigenDateStr(bigenDateStr);
            wa.setWaEndDateStr(endDateStr);
        }
        return waterAmountList;
    }

    public void updateWaterStatu(List<WaterAmount> waterAmounts){
        for (WaterAmount wa: waterAmounts) {
            waterAmountMapper.updateWaterStatu(wa);
        }

    }

}
