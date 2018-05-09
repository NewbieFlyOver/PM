package com.pm.dsis.lr.controllers;

import com.pm.dsis.lr.service.LrService;
import com.pm.dsis.lr.service.ServiceImpl.LrServiceImpl;
import com.pm.dsis.mm.dto.UserInfo;
import com.pm.platform.BaseController;
import com.pm.platform.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/4/20.
 */
@Controller
public class LrController extends BaseController{

    @Autowired
    private LrService lrService;

    @Autowired
    private MessageSource messageSource;


    private Logger logger = LoggerFactory.getLogger(LrController.class);

    @RequestMapping("/")
    public String test(){
        return "index";
    }

    @RequestMapping("/{page}")
    public ModelAndView index(@PathVariable String page){
        ModelAndView mv = new ModelAndView();
        mv.setViewName(page);
        return mv;
    }

    @RequestMapping("/verifiCode")
    public void code(HttpServletRequest req, HttpServletResponse resp) throws Exception{
            // 禁止图像缓存。
            resp.setHeader("Pragma", "no-cache");
            resp.setHeader("Cache-Control", "no-cache");
            resp.setDateHeader("Expires", 0);
            resp.setContentType("image/jpeg");
            lrService.generateCaptcha();
    }

    /**
     * 登录
     * @param
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, UserInfo userInfo) throws Exception{
        ModelAndView mv = new ModelAndView();
       // mv.setViewName("redirect:/index");
        lrService.selectLoginInfo(mv, userInfo);
        return mv;
    }

    /**
     * 退出登录
     * @param
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout(HttpServletRequest request, HttpServletResponse response,String loginFlag) throws Exception{
       if("admin".equals(loginFlag)) {
           LrServiceImpl.adminLoginFlag = 0;
       }
        if("user".equals(loginFlag)) {
            LrServiceImpl.userLoginFlag = 0;
        }
    }



    /**
     * 新户激活
     * @param
     * @return
     */
    @RequestMapping(value = "/active",method = RequestMethod.POST)
    public ModelAndView active(HttpServletRequest request, HttpServletResponse response, UserInfo userInfo)
            throws Exception{
        String name = userInfo.getUserName();
        ModelAndView mv = new ModelAndView();
        lrService.activeUser(request,mv,userInfo);
        //mv.setViewName("redirect:/view/mws/index.html");
        //mv.setViewName("redirect:/index");
        return mv;
    }

    /**
     * 查询账号
     * @param request
     * @param response
     * @param account
     * @return
     */
    @RequestMapping(value = "/lr/selectAccount",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData selectAccount(HttpServletRequest request, HttpServletResponse response, String account){

        int num = lrService.selectAccount(account);
        if (num > 0) {
            return new ResponseData(false);
        } else {
            return new ResponseData(true) ;
        }
    }


    /**
     * 验证激活信息
     * @param request
     * @param response
     * @param bfr
     * @param name
     * @param idNum
     * @return
     */
    @RequestMapping(value = "/lr/validationAccount",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData validationAccount(HttpServletRequest request, HttpServletResponse response,
                                          String bfr,String name,String idNum){

        int num = lrService.validationAccount(bfr,name,idNum);
        if (num > 0) {
            return new ResponseData(false);
        } else {
            return new ResponseData(true) ;
        }
    }


    /**
     * 是否被激活
     * @param request
     * @param response
     * @param bfr
     * @param name
     * @param idNum
     * @return
     */
    @RequestMapping(value = "/lr/active",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData active(HttpServletRequest request, HttpServletResponse response,
                                          String bfr,String name,String idNum){

        int num = lrService.validationAccount(bfr,name,idNum);
        if (num > 0) {
            return new ResponseData(false);
        } else {
            return new ResponseData(true) ;
        }
    }



    /**
     * 修改密码
     * @param request
     * @param response
     * @param userId
     * @param oldPwd
     * @param newPwd
     * @param flag
     * @return
     */
    @RequestMapping(value = "/lr/resetPwd",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData resetPwd(HttpServletRequest request, HttpServletResponse response,
                                 Long userId, String oldPwd, String newPwd, String flag) throws Exception{
        ResponseData responseData = new ResponseData();
        int sum = lrService.resetPwd(userId, oldPwd, newPwd,flag);
        if (sum == 0 ) {
            responseData.setMessage("旧密码错误！");
            responseData.setSuccess(false);
        } else {
            responseData.setMessage("密码修改成功！");
            responseData.setSuccess(true);
        }
        return responseData;
    }
}
