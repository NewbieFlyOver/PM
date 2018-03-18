package com.pm.dsis.mm.controllers;

import com.pm.dsis.mm.dto.UserInfo;
import com.pm.dsis.mm.dto.UserMember;
import com.pm.dsis.mm.service.UserInfoService;
import com.pm.platform.ResponseData;
import com.taotao.dto.Items;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/3/18.
 */
@Controller
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/mm/saveUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData saveUserInfo(HttpServletRequest request, HttpServletResponse response,@RequestBody UserInfo userInfo){

        int i = userInfoService.insertUserInfo(userInfo);
        return null;

    }

    /**
     * 保存/更新常住成员的信息
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/mm/saveUserMember",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData saveUserInfo(HttpServletRequest request, HttpServletResponse response,@RequestBody List<UserMember> userInfo){
        userInfoService.insertUserMember(userInfo);
        return new ResponseData();

    }

    @RequestMapping(value = "/mm/selectAllUserMember",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData selectAllUserInfo(HttpServletRequest request, HttpServletResponse response){
       return new ResponseData(userInfoService.selectAllUserMember());
    }

    @RequestMapping(value = "/mm/deteleUserMember",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData deteleUserInfo(HttpServletRequest request, HttpServletResponse response,@RequestBody List<UserMember> userMemberList){

        userInfoService.deleteById(userMemberList);
        return new ResponseData(userInfoService.selectAllUserMember());
    }


}
