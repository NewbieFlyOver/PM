package com.pm.platform;

import com.pm.dsis.lr.service.ServiceImpl.LrServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 登录验证
 * Created by admin on 2018/5/2.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private final static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception{
        logger.info("loginInterceptor");

        //TODO：登录验证
        if (!LrServiceImpl.loginFlag) {
            response.sendRedirect("/view/activeLogin/index.html");
            return false;
        }

       /* if(LrServiceImpl.userLoginFlag == 0) {
            response.sendRedirect("/view/activeLogin/index.html");
            return false;
        }

        if(LrServiceImpl.adminLoginFlag == 0) {
            response.sendRedirect("/view/activeLogin/index.html");
            return false;
        }*/

        /*if(LrServiceImpl.userLoginFlag == 0) {
            response.sendRedirect("/view/activeLogin/index.html");
           // LrServiceImpl.userLoginFlag = 0;
            return false;
        }
        if(LrServiceImpl.adminLoginFlag == 0) {
            response.sendRedirect("/view/activeLogin/index.html");
           // LrServiceImpl.adminLoginFlag = 0;
            return false;
        }*/
        return true;
    }


  /*  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        request.setAttribute(SESSION_INTERCEPTOR_TOKEN, true);
        HttpSession session = request.getSession(false);
        String contextPath = request.getContextPath();
        if (session == null) {
            if (RequestUtil.isAjaxRequest(request)) {
                try (Writer writer = response.getWriter()) {
                    writer.write(DEFAULT_AJAX_RESPONSE);
                }
            } else {
                String path = request.getRequestURI().substring(contextPath.length());
                if ("".equals(path) || "/".equals(path)) {
                    request.getRequestDispatcher("/login").forward(request, response);
                } else if("/loginSysOthUsers".equals(path)){
                    request.getRequestDispatcher("/loginSomethingOtherUsers").forward(request, response);
                }else {
                    response.sendRedirect(contextPath + defaultPageManager.getPageLogin());
                }
                // response.sendRedirect(contextPath + "/timeout.html");
            }
            return false;
        } else {
            String tz = (String) session.getAttribute(BaseConstants.TIME_ZONE);
            if (StringUtils.isNotEmpty(tz)) {
                TimeZoneUtil.setTimeZone(TimeZone.getTimeZone(tz));
            }
        }
        return true;
    }*/




}
