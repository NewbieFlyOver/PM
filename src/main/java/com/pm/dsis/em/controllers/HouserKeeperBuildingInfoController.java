package com.pm.dsis.em.controllers;

import com.pm.dsis.cm.dto.ElectricityAmount;
import com.pm.dsis.em.dto.HousekeeperBuildingInfo;
import com.pm.dsis.em.service.HousekeeperBuildingInfoService;
import com.pm.platform.ResponseData;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/4/15.
 */
@Controller
public class HouserKeeperBuildingInfoController {

    @Autowired
    private HousekeeperBuildingInfoService housekeeperBuildingInfoService;



    /**
     * 批量添加/更新用电量
     * @param request
     * @param response
     * @param housekeeperBuildingInfo
     * @return
     */
    @RequestMapping(value = "/em/insertHouseInfo",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData insertHouseInfo(HttpServletRequest request, HttpServletResponse response,
                                    @RequestBody HousekeeperBuildingInfo housekeeperBuildingInfo) throws Exception{

        housekeeperBuildingInfoService.insertHouseInfo(housekeeperBuildingInfo);
        return new ResponseData();

    }

    /**
     * 根据id查找
     * @param request
     * @param response
     * @param hdId
     * @return
     */
    @RequestMapping(value = "/em/selectHouseInfoById",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData selectHouseInfoById(HttpServletRequest request, HttpServletResponse response,
                                            Long hdId){
        HousekeeperBuildingInfo hbi = housekeeperBuildingInfoService.selectHouseInfoById(hdId);
        List<HousekeeperBuildingInfo> hbiList = new ArrayList<HousekeeperBuildingInfo>();
        hbiList.add(hbi);
        return new ResponseData(hbiList);

    }

    /**
     * 根据条件查询所有的员工信息
     * @param request
     * @param response
     * @param housekeeperBuildingInfo
     * @return
     */
    @RequestMapping(value = "/em/selectHbByCondtion",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData selectHbByCondtion(HttpServletRequest request, HttpServletResponse response,
                                           @RequestBody HousekeeperBuildingInfo housekeeperBuildingInfo){

        return new ResponseData(housekeeperBuildingInfoService.selectHbByCondtion(housekeeperBuildingInfo));
    }




}
