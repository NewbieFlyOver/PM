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
     * 登录
     * @param userInfo
     */
    void selectLoginInfo(ModelAndView mv, UserInfo userInfo) throws Exception;

    /**
     * 退出登录
     */
   // void logout(ModelAndView mv) throws Exception;



    /**
     * 查询账号是否村子
     * @param account
     * @return
     */
    int selectAccount(String account);

    /**
     * 验证激活信息
     * @param bfr
     * @param name
     * @param idNum
     * @return
     */
    int validationAccount(String bfr,String name,String idNum);

    /**
     * 是否被激活
     * @param bfr
     * @param name
     * @param idNum
     * @return
     */
    int active(String bfr,String name,String idNum);

    /**
     * 重置密码
     * @param userId
     * @param oldPwd
     * @param newPwd
     * @return
     */
    int resetPwd(Long userId, String oldPwd, String newPwd, String flag)  throws Exception;



}
