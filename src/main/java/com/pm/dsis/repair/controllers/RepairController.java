package com.pm.dsis.repair.controllers;

import com.pm.dsis.cm.dto.ElectricityAmount;
import com.pm.dsis.repair.dto.RepairInfo;
import com.pm.dsis.repair.service.RepairService;
import com.pm.platform.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;
import java.util.UUID;

/**
 * Created by admin on 2018/4/24.
 */
@Controller
public class RepairController {


    @Autowired
    private RepairService repairService;


    /**
     * 提交报修记录
     * @param request
     * @param response
     * @param repairInfo
     * @return
     */
    @RequestMapping(value = "/repair/saveRepairInfo",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData saveRepairInfo(HttpServletRequest request, HttpServletResponse response,  RepairInfo repairInfo,
                                       @RequestParam(value="file",required=false) MultipartFile file) throws Exception{
        System.out.println(repairInfo.toString());
        //获得物理路径webapp所在路径
        //String pathRoot = request.getSession().getServletContext().getRealPath("");
        String pathRoot = "D:/Graduation design/code/PM";
        String path="";
        if(!file.isEmpty()){
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType=file.getContentType();
            //获得文件后缀名称
            String imageName=contentType.substring(contentType.indexOf("/")+1);
            path=pathRoot+"/images/"+uuid+"."+imageName;
            file.transferTo(new File(path));
        }
        repairInfo.setRiImg(path);
        repairInfo.setRiDate(new Date());
        repairService.insertRepairInfo(repairInfo);
        return new ResponseData();
    }



    @RequestMapping(value = "/repair/selectRepairInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData selectRepairInfo(HttpServletRequest request, HttpServletResponse response,
                                         @RequestBody RepairInfo repairInfo) {
        return new ResponseData(repairService.selectRepairInfo(repairInfo));
    }




}
