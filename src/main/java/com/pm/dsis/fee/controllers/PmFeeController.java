package com.pm.dsis.fee.controllers;

import com.pm.dsis.cm.dto.WaterAmount;
import com.pm.dsis.fee.dto.PmFee;
import com.pm.dsis.fee.service.PmFeeService;
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
 * Created by admin on 2018/3/25.
 */
@Controller
public class PmFeeController {

    @Autowired
    private PmFeeService pmFeeService;

    /**
     * 条件查询
     * @param request
     * @param response
     * @param pmFee
     * @return
     */
    @RequestMapping(value = "/fee/selecPmFee",method = RequestMethod.POST)
    @ResponseBody//
    public ResponseData selecPmFee(HttpServletRequest request, HttpServletResponse response, @RequestBody PmFee pmFee){
        return new ResponseData(pmFeeService.selectPmFee(pmFee));
    }

    /**
     * 更新是否缴费状态
     * @param request
     * @param response
     * @param pmFees
     * @return
     */
    @RequestMapping(value = "/fee/updatePmFeeStatu",method = RequestMethod.POST)
    @ResponseBody//
    public ResponseData updatePmFeeStatu(HttpServletRequest request, HttpServletResponse response, @RequestBody List<PmFee> pmFees){
        pmFeeService.updatePmFeeStatu(pmFees);
        return new ResponseData();

    }

}
