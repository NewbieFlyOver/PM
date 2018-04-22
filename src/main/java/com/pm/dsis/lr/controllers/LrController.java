package com.pm.dsis.lr.controllers;

import com.pm.dsis.lr.service.LrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by admin on 2018/4/20.
 */
@Controller
public class LrController {

    @Autowired
    private LrService lrService;

    @RequestMapping("/")
    public  String test(){
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







}
