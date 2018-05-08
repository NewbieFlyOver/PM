package com.pm.dsis.fee.controllers;

import com.pm.dsis.fee.dto.PmFee;
import com.pm.dsis.fee.dto.PmUnitPrice;
import com.pm.dsis.fee.service.PmUnitPriceService;
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
public class PmUnitPriceController {

    @Autowired
    private PmUnitPriceService pmUnitPriceService;

    /**
     * 更新物业费用
     * @param request
     * @param response
     * @param pmUnitPrice
     * @return
     */
    @RequestMapping(value = "/fee/updatePmUnitPriceById",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData updatePmUnitPriceById(HttpServletRequest request, HttpServletResponse response, @RequestBody List<PmUnitPrice> pmUnitPrices){
        pmUnitPriceService.updatePmUnitPriceById(pmUnitPrices);
        return new ResponseData();

    }

    /**
     * 查询物业费用
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/fee/selectPmUnitPrice",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData selectPmUnitPrice(HttpServletRequest request, HttpServletResponse response){

        return new ResponseData(pmUnitPriceService.selectPmUnitPrice ());

    }

}
