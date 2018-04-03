package com.pm.dsis.common.controllers;

import com.pm.dsis.common.dto.CommonInfo;
import com.pm.dsis.common.service.CommonInfoService;
import com.pm.platform.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by admin on 2018/4/2.
 */
@Controller
public class CommonInfoController {

    @Autowired
    private CommonInfoService commonInfoService;


    /**
     * 根据通用类型查询通用信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/ci/selectByType")
    @ResponseBody
    public ResponseData selectByType(HttpServletRequest request, HttpServletResponse response, @RequestParam String commonType){
        List<CommonInfo> commonInfoList = commonInfoService.selectByType(commonType);
        return new ResponseData(commonInfoList);
    }





}
