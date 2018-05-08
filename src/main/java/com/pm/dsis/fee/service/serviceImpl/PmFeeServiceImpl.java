package com.pm.dsis.fee.service.serviceImpl;

import com.pm.dsis.fee.dto.PmFee;
import com.pm.dsis.fee.mapper.PmFeeMapper;
import com.pm.dsis.fee.service.PmFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2018/3/25.
 */
@Service
public class PmFeeServiceImpl implements PmFeeService{

    @Autowired
    private PmFeeMapper pmFeeMapper;


    public void insert() {
        List<PmFee> pmFeeList = pmFeeMapper.selectPriceAndType();
        for (PmFee pf : pmFeeList) {
            Date date = new Date();
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = sdf.format(date);

            String yearStr = dateStr.substring(0,dateStr.length()-6);
            String monthStr = dateStr.substring(5,7);
            String nextMonthStr = "";
            String dayStr = "28";

            yearStr = (Integer.parseInt(yearStr) + 1)+"" ;

            for (int i=1;i<13;i++) {
                 if (i<10) {
                     monthStr = "0" + i;
                 }else{
                     monthStr = "" +i ;
                 }
                 if (i+1<10) {
                     nextMonthStr = "0"+(i+1);
                 }else{
                     nextMonthStr = ""+(i+1);
                 }

                SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
                String beginDateS = yearStr+"-"+monthStr+"-"+dayStr;
                String endDateS = yearStr+"-"+nextMonthStr+"-"+dayStr;
                Date beginDate = null;
                Date endDate = null;
                try {
                    beginDate = formatter.parse(beginDateS);
                    endDate =formatter.parse(endDateS);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                Float sumFee = pf.getPmPrice()*pf.getBuildingArea();
                //添加月份
                pf.setPmBeginDate(beginDate);
                pf.setPmEndDate(endDate);
                pf.setPmMonth(Integer.parseInt(yearStr+monthStr));
                pf.setMonthFee(sumFee);
                pmFeeMapper.insert(pf);
            }
        }
    }


    /**
     * 添加当年剩下月份的物业费
     * @return
     */
    public void insertRePmFee(String buildFullRoom) {
        List<PmFee> pmFeeList = pmFeeMapper.selectPriceAndType();
        for (PmFee pf : pmFeeList) {
            Date date = new Date();
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = sdf.format(date);

            String yearStr = dateStr.substring(0,dateStr.length()-6);
            String monthStr = dateStr.substring(5,7);
            String nextMonthStr = "";
            String dayStr = "28";

            int monthInt = Integer.parseInt(monthStr);

            for (int i=1;i<13;i++) {
                if (i<10) {
                    monthStr = "0" + i;
                }else{
                    monthStr = "" +i ;
                }
                if (i+1<10) {
                    nextMonthStr = "0"+(i+1);
                }else{
                    nextMonthStr = ""+(i+1);
                }

                SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
                String beginDateS = yearStr+"-"+monthStr+"-"+dayStr;
                String endDateS = yearStr+"-"+nextMonthStr+"-"+dayStr;
                Date beginDate = null;
                Date endDate = null;
                try {
                    beginDate = formatter.parse(beginDateS);
                    endDate =formatter.parse(endDateS);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                Float sumFee = pf.getPmPrice()*pf.getBuildingArea();
                //添加月份
                pf.setPmBeginDate(beginDate);
                pf.setPmEndDate(endDate);
                pf.setPmMonth(Integer.parseInt(yearStr+monthStr));
                pf.setMonthFee(sumFee);
                pmFeeMapper.insert(pf);
            }
        }
    }

    public List<PmFee> selectPmFee(PmFee pmFee){
        List<PmFee> pmFeeList = pmFeeMapper.selectPmFee(pmFee);
        for (PmFee pf : pmFeeList) {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String bigenDateStr = sdf.format(pf.getPmBeginDate());
            String endDateStr = sdf.format(pf.getPmEndDate());
            pf.setBeginDateStr(bigenDateStr);
            pf.setEndDateStr(endDateStr);
        }
        return pmFeeList;
    }
    /**
     * 根据userId查询
     * @param pmFee
     * @return
     */
    public List<PmFee> selectPmFeeById(PmFee pmFee) {
        List<PmFee> pmFeeList = pmFeeMapper.selectPmFeeById(pmFee);
        for (PmFee pf : pmFeeList) {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String bigenDateStr = sdf.format(pf.getPmBeginDate());
            String endDateStr = sdf.format(pf.getPmEndDate());
            pf.setBeginDateStr(bigenDateStr);
            pf.setEndDateStr(endDateStr);
        }
        return pmFeeList;
    }


    public void updatePmFeeStatu(List<PmFee> pmFees){
        for (PmFee pf:pmFees){
            pmFeeMapper.updatePmFeeStatu(pf);
        }
    }

}
