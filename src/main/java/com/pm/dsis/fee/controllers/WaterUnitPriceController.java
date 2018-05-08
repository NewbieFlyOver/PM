package com.pm.dsis.fee.controllers;

import com.pm.dsis.fee.dto.PmFee;
import com.pm.dsis.fee.dto.WaterUnitPrice;
import com.pm.dsis.fee.service.WaterUnitPriceService;
import com.pm.platform.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by admin on 2018/5/8.
 */
@Controller
public class WaterUnitPriceController {

    @Autowired
    private WaterUnitPriceService waterUnitPriceService;


    /**
     * 更改或添加水价
     * @param request
     * @param response
     * @param waterUnitPrices
     * @return
     */
    @RequestMapping(value = "/fee/updateWaterUnitPriceById",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData updateWaterUnitPriceById(HttpServletRequest request, HttpServletResponse response, @RequestBody List<WaterUnitPrice> waterUnitPrices){
        waterUnitPriceService.updateWaterUnitPriceById(waterUnitPrices);
        return new ResponseData();

    }


    /**
     * 删除水价
     * @param request
     * @param response
     * @param waterUnitPrices
     * @return
     */
    @RequestMapping(value = "/fee/deleteWaterUnitPriceById",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData deleteWaterUnitPriceById(HttpServletRequest request, HttpServletResponse response, @RequestBody List<WaterUnitPrice> waterUnitPrices){
        waterUnitPriceService.deleteWaterUnitPriceById(waterUnitPrices);
        return new ResponseData();

    }

    /**
     * 查询所有水价
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/fee/selectAllWaterPrice",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData selectAllWaterPrice(HttpServletRequest request, HttpServletResponse response){
        return new ResponseData(waterUnitPriceService.selectAllWaterPrice());

    }


}
