package com.pm.dsis.cm.service.serviceImpl;

import com.pm.dsis.cm.dto.ElectricityAmount;
import com.pm.dsis.cm.mapper.ElectricityAmountMapper;
import com.pm.dsis.cm.service.ElectAmountService;
import com.pm.dsis.fee.dto.ElectricityUnitPrice;
import com.pm.dsis.fee.mapper.ElectricityUnitPriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            if (ea.getEaId() == null) {
                Date date = ea.getEaBigenDate();
                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dateStr = sdf.format(date);

                String yearStr = dateStr.substring(0,dateStr.length()-6);
                String monthStr = dateStr.substring(5,7);

                int yearInt = Integer.parseInt(yearStr);
                int monthInt = Integer.parseInt(monthStr);

                ea.setEaMonth(Integer.parseInt(dateStr.substring(0,dateStr.length()-6)+dateStr.substring(5,7)));

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
                //查询上月用量
                int monthPara = Integer.parseInt(month);
                ElectricityAmount electricityAmount = electricityAmountMapper.selectByRoomMonth(monthPara,ea.getBuildingFullRoom());

                //获取本月用量
                if ( electricityAmount ==null ) {
                    ea.setEaDosage(ea.getEaNumber());
                }else{
                    ea.setEaDosage(ea.getEaNumber()-electricityAmount.getEaNumber());
                }
                //根据本月用量计算本月费用
                //获取水价阶梯
                List<ElectricityUnitPrice> electricityUnitPrices = electricityUnitPriceMapper.selectAllelectPrice();
                float tempElect = ea.getEaDosage();
                float electSum = 0L;
                for (ElectricityUnitPrice eup:electricityUnitPrices) {
                    //超过最大值处理
                    if (tempElect > eup.getEaUrLower() || tempElect == eup.getEaUrLower() ) {
                        float temp = eup.getEaUrPrice() * (tempElect - eup.getEaUrLower());
                        electSum = electSum + temp;
                        tempElect = tempElect - eup.getEaUrLower();
                        System.out.println(eup.getEaUrPrice() +"*"+ (tempElect - eup.getEaUrLower()));
                    }
                }
                ea.setMonthFee(electSum);
                //添加本月用电信息
                ElectricityAmount elecAmount = electricityAmountMapper.selectByRoomMonth(ea.getEaMonth(),ea.getBuildingFullRoom());
                if (elecAmount == null) {
                    electricityAmountMapper.insertElect(ea);
                } else {
                    System.out.println("此月数据已存在！");
                }

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
