package com.pm.dsis.fee.controllers;

import com.pm.dsis.fee.dto.ElectricityUnitPrice;
import com.pm.dsis.fee.dto.WaterUnitPrice;
import com.pm.dsis.fee.service.ElectUnitPriceService;
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
public class ElectUnitPriceController {

    @Autowired
    private ElectUnitPriceService electUnitPriceService;


    /**
     * 更改或添加水价
     * @param request
     * @param response
     * @param electricityUnitPrices
     * @return
     */
    @RequestMapping(value = "/fee/updateElectUnitPriceById",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData updateElectUnitPriceById(HttpServletRequest request, HttpServletResponse response, @RequestBody List<ElectricityUnitPrice> electricityUnitPrices){
        electUnitPriceService.updateElectUnitPriceById(electricityUnitPrices);
        return new ResponseData();

    }


    /**
     * 删除水价
     * @param request
     * @param response
     * @param electricityUnitPrices
     * @return
     */
    @RequestMapping(value = "/fee/deleteElectUnitPriceById",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData deleteElectUnitPriceById(HttpServletRequest request, HttpServletResponse response, @RequestBody List<ElectricityUnitPrice> electricityUnitPrices){
        electUnitPriceService.deleteElectUnitPriceById(electricityUnitPrices);
        return new ResponseData();

    }

    /**
     * 查询所有水价
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/fee/selectAllelectPrice",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData selectAllelectPrice(HttpServletRequest request, HttpServletResponse response){
        return new ResponseData(electUnitPriceService.selectAllelectPrice());

    }



}
