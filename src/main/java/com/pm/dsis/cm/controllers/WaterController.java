package com.pm.dsis.cm.controllers;

import com.pm.dsis.cm.dto.WaterAmount;
import com.pm.dsis.cm.service.WaterAmountService;
import com.pm.dsis.mm.dto.UserInfo;
import com.pm.platform.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/3/25.
 */
@Controller
public class WaterController {

    @Autowired
    private WaterAmountService waterAmountService;

    /**
     * 批量添加/更新用水量
     * @param request
     * @param response
     * @param waterAmounts
     * @return
     */
    @RequestMapping(value = "/cm/insertWaterAmount",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData insertWaterAmount(HttpServletRequest request, HttpServletResponse response,
                                           @RequestBody List<WaterAmount> waterAmounts){
        waterAmountService.insertWaterAmount(waterAmounts);
        return new ResponseData();

    }

    /**
     * 批量更改用水量
     * @param request
     * @param response
     * @param waterAmounts
     * @return
     */
    @RequestMapping(value = "/cm/updateByWaterAId",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData updateByWaterAId(HttpServletRequest request, HttpServletResponse response,
                                          @RequestBody List<WaterAmount> waterAmounts){

        waterAmountService.updateByWaterAId(waterAmounts);
        return new ResponseData();

    }



    /**
     * 批量删除用水量
     * @param request
     * @param response
     * @param waterAmounts
     * @return
     */
    @RequestMapping(value = "/cm/deleteByWaterAId",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData deleteByWaterAId(HttpServletRequest request, HttpServletResponse response,
                                         @RequestBody List<WaterAmount> waterAmounts){

        waterAmountService.deleteByWaterAId(waterAmounts);
        return new ResponseData();

    }

    /**
     * 根据月份查询用水量
     * @param request
     * @param response
     * @param month
     * @return
     */
    @RequestMapping(value = "/cm/selectWaterAByMonth",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData selectWaterAByMonth(HttpServletRequest request, HttpServletResponse response,
                                         @RequestParam int month){
        return new ResponseData(waterAmountService.selectWaterAByMonth(month));

    }

    /**
     * 条件查询
     * @param request
     * @param response
     * @param waterAmount
     * @return
     */
    @RequestMapping(value = "/cm/selectWater",method = RequestMethod.POST, consumes="application/json")
    @ResponseBody//
    public ResponseData selectWater(HttpServletRequest request, HttpServletResponse response, @RequestBody WaterAmount waterAmount){
        return new ResponseData(waterAmountService.selectWater(waterAmount));

    }

    /**
     * 条件userId查询
     * @param request
     * @param response
     * @param waterAmount
     * @return
     */
    @RequestMapping(value = "/cm/selectWaterByUserId",method = RequestMethod.POST, consumes="application/json")
    @ResponseBody//
    public ResponseData selectWaterByUserId(HttpServletRequest request, HttpServletResponse response, @RequestBody WaterAmount waterAmount){
        return new ResponseData(waterAmountService.selectWaterByUserId(waterAmount));

    }


    /**
     * 更新是否缴费状态
     * @param request
     * @param response
     * @param waterAmounts
     * @return
     */
    @RequestMapping(value = "/cm/updateWaterStatu",method = RequestMethod.POST)
    @ResponseBody//
    public ResponseData updateWaterStatu(HttpServletRequest request, HttpServletResponse response, @RequestBody List<WaterAmount> waterAmounts){
        //WaterAmount waterAmount = new WaterAmount();
        waterAmountService.updateWaterStatu(waterAmounts);
        return new ResponseData();

    }
}
