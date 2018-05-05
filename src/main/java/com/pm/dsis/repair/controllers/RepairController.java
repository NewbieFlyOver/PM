package com.pm.dsis.repair.controllers;

import com.pm.dsis.cm.dto.ElectricityAmount;
import com.pm.dsis.repair.dto.RepairInfo;
import com.pm.dsis.repair.service.RepairService;
import com.pm.platform.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;
import java.util.List;
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
    public ModelAndView saveRepairInfo(HttpServletRequest request, HttpServletResponse response, RepairInfo repairInfo,
                                       @RequestParam(value="file",required=false) MultipartFile file) throws Exception{
        ModelAndView mv = new ModelAndView();
        //获得物理路径webapp所在路径
        //String pathRoot = request.getSession().getServletContext().getRealPath("");
        //String pathRoot = "D:/Graduation design/code/PM";
        String pathRoot = "D:/Graduation design/code/PM/propertyManagement/src/main/webapp/WEB-INF/images/riImg/";
        String path="";
        String picName = "";
        if(!file.isEmpty()){
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType=file.getContentType();
            //获得文件后缀名称
            String imageName=contentType.substring(contentType.indexOf("/")+1);
            picName = uuid+"."+imageName;
            path=pathRoot+picName;
            file.transferTo(new File(path));
        }
        repairInfo.setRiImg(picName);
        repairInfo.setRiDate(new Date());
        int sum = repairService.insertRepairInfo(repairInfo);
        if (sum == 1) {
            mv.addObject("msg","报修成功！");
        }else {
            mv.addObject("msg","报修失败！");
        }
        mv.setViewName("redirect:/view/mws/ri/ri_info.html");
        return mv;
    }



    @RequestMapping(value = "/repair/selectRepairInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData selectRepairInfo(HttpServletRequest request, HttpServletResponse response,
                                         @RequestBody RepairInfo repairInfo) {
        return new ResponseData(repairService.selectRepairInfo(repairInfo));
    }

    @RequestMapping(value = "/repair/updateRepairInfoById", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData updateRepairInfoById(HttpServletRequest request, HttpServletResponse response,
                                         @RequestBody List<RepairInfo> repairInfos) {
        repairService.updateRepairInfoById(repairInfos);
        return new ResponseData();
    }



}
