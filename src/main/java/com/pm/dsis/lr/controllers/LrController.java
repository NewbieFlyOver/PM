package com.pm.dsis.lr.controllers;

import com.pm.dsis.lr.service.LrService;
import com.pm.dsis.mm.dto.UserInfo;
import com.pm.platform.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    /*public String active() throws Exception{
        if (true)
         throw new Exception("新户激活成功！");*/
        /*ModelAndView mv = new ModelAndView();
        mv.setViewName("/index");
        return "index";
    }*/

//http://localhost:8088/lr/home
}
