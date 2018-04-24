package com.pm.dsis.gs.controllers;

import com.pm.dsis.fee.dto.PmFee;
import com.pm.dsis.gs.dto.GarageState;
import com.pm.dsis.gs.service.GarageStateService;
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
 * Created by admin on 2018/4/9.
 */
@Controller
public class GarageStateController {

    @Autowired
    private GarageStateService garageStateService;


    /**
     * 条件查询
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/gs/selectGarageState",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData selectGarageState(HttpServletRequest request, HttpServletResponse response,@RequestBody GarageState garageState){
        return new ResponseData(garageStateService.selectGarageState(garageState));
    }

    /**
     * 条件查询
     * @param request
     * @param response
     * @return
             */
    @RequestMapping(value = "/gs/selectGarageStateByUserId",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData selectGarageStateByUserId(HttpServletRequest request, HttpServletResponse response,@RequestBody GarageState garageState){
        return new ResponseData(garageStateService.selectGarageStateByUserId(garageState));
    }


    /**
     * 添加
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/gs/insertGarageState",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData insertGarageState(HttpServletRequest request, HttpServletResponse response,@RequestBody GarageState garageStates){
        garageStateService.insertGarageState(garageStates);
        return new ResponseData();
    }

    /**
     * 更新状态至空闲
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/gs/updateByGsId",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData updateByGsId(HttpServletRequest request, HttpServletResponse response,@RequestBody GarageState garageStates){
        garageStateService.updateByGsId(garageStates);
        return new ResponseData();
    }
}
