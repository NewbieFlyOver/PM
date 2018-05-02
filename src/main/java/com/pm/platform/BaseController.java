/*
 *
 */
package com.pm.platform;

/*import com.lkkhpg.dsis.platform.core.IRequest;
import com.lkkhpg.dsis.platform.core.impl.RequestHelper;
import com.lkkhpg.dsis.platform.dto.ResponseData;
import com.lkkhpg.dsis.platform.dto.system.Account;
import com.lkkhpg.dsis.platform.dto.system.Role;
import com.lkkhpg.dsis.platform.dto.system.User;
import com.lkkhpg.dsis.platform.exception.TokenException;
import com.lkkhpg.dsis.platform.security.DefaultConfiguration;
import com.lkkhpg.dsis.platform.security.TokenUtils;
import com.lkkhpg.dsis.platform.util.RequestUtil;
import com.lkkhpg.dsis.platform.validator.FieldErrorWithBean;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Locale;

/**
 * BaseController.
 *
 * @author njq.niu@hand-china.com
 *         <p>
 *         2016年1月5日
 */
@Controller
public class BaseController {
    private Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    private MessageSource messageSource;

    /**
     * 处理控制层所有异常.
     *
     * @param exception
     *            未捕获的异常
     * @param request
     *            HttpServletRequest
     * @return ResponseData(BaseException 被处理) 或者 ModelAndView(其他 Exception
     *         ,500错误)
     */
    @ExceptionHandler(value = { Exception.class })
    @ResponseBody
    public Object exceptionHandler(Exception exception, HttpServletRequest request) {
        if (logger.isErrorEnabled()) {
            logger.error(exception.getMessage(), exception);
        }

        Throwable thr = getRootCause(exception);
        ResponseData res = new ResponseData(false);
        res.setMessage(thr.getMessage());
        return res;
    }


   /* public Object exceptionHandler(Exception exception, HttpServletRequest request) {
    	if (logger.isErrorEnabled()) {
    		logger.error(exception.getMessage(), exception);
    	}
        if (RequestUtil.isAjaxRequest(request)) {
            Throwable thr = getRootCause(exception);
            ResponseData res = new ResponseData(false);
            if (thr instanceof BaseException) {
                BaseException be = (BaseException) thr;
                Locale locale = RequestContextUtils.getLocale(request);
                String messageKey = be.getDescriptionKey();
                String message = messageSource.getMessage(messageKey, be.getParameters(), messageKey, locale);
                res.setCode(be.getCode());
                res.setMessage(message);
            } else {
                res.setMessage(thr.getMessage());
            }
            return res;
        } else {
            return new ModelAndView("500");
        }
    }*/
    private Throwable getRootCause(Throwable throwable) {
        while (throwable.getCause() != null) {
            throwable = throwable.getCause();
        }
        return throwable;
    }

}
