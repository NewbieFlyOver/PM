package com.pm.dsis.lr.service;

import com.pm.dsis.mm.dto.UserInfo;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by admin on 2018/4/20.
 */
public interface LrService {

    void generateCaptcha() throws IOException;

    /**
     * 激活新用户
     * @param request
     * @param mv
     * @param userInfo
     * @throws Exception
     */
    void activeUser(HttpServletRequest request, ModelAndView mv, UserInfo userInfo) throws Exception;


    /**
     * 查询登录信息
     * @param userInfo
     * @return
     */
    void selectLoginInfo(ModelAndView mv, UserInfo userInfo) throws Exception;


}
