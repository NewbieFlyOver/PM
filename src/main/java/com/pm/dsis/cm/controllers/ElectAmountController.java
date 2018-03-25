package com.pm.dsis.cm.controllers;

import com.pm.dsis.cm.dto.ElectricityAmount;
import com.pm.dsis.cm.dto.WaterAmount;
import com.pm.dsis.cm.service.ElectAmountService;
import com.pm.platform.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by admin on 2018/3/25.
 */
@Controller
public class ElectAmountController {

    @Autowired
    private ElectAmountService electAmountService;



    /**
     * 批量添加/更新用电量
     * @param request
     * @param response
     * @param electricityAmounts
     * @return
     */
    @RequestMapping(value = "/cm/insertElect",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData insertElect(HttpServletRequest request, HttpServletResponse response,
                                    @RequestBody List<ElectricityAmount> electricityAmounts){

        electAmountService.insertElect(electricityAmounts);
        return new ResponseData();

    }

    /**
     * 根据月份查询用电量
     * @param request
     * @param response
     * @param month
     * @return
     */
    @RequestMapping(value = "/cm/selectByMonth",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData selectByMonth(HttpServletRequest request, HttpServletResponse response,
                                      @RequestParam int month){
        return new ResponseData(electAmountService.selectByMonth(month));

    }
    /**
     * 批量删除用电量
     * @param request
     * @param response
     * @param electricityAmounts
     * @return
     */
    @RequestMapping(value = "/cm/deleteByEAId",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData deleteByEAId(HttpServletRequest request, HttpServletResponse response,
                                     @RequestBody List<ElectricityAmount> electricityAmounts){
        electAmountService.deleteByEAId(electricityAmounts);
        return new ResponseData();

    }
}
