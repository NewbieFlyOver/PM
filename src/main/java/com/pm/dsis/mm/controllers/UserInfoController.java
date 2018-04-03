package com.pm.dsis.mm.controllers;

import com.pm.dsis.mm.dto.*;
import com.pm.dsis.mm.service.UserInfoService;
import com.pm.platform.ResponseData;
import com.taotao.dto.Items;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 保存/更新户主信息
     * @param request
     * @param response
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/mm/saveUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData saveUserInfo(HttpServletRequest request, HttpServletResponse response,@RequestBody UserInfo userInfo){

        int i = userInfoService.insertUserInfo(userInfo);
        Long lastUserId = userInfoService.queryUserId();
        List<Long> userIds = new ArrayList<Long>();
        userIds.add(lastUserId);
        return new ResponseData(userIds);

    }

    /**
     * 保存户主信息
     * @param request
     * @param response
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/mm/addUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData addUserInfo(HttpServletRequest request, HttpServletResponse response,@RequestBody UserInfo userInfo){

        int i = userInfoService.addUserInfo(userInfo);
        Long lastUserId = userInfoService.queryUserId();
        List<Long> userIds = new ArrayList<Long>();
        userIds.add(lastUserId);
        return new ResponseData(userIds);

    }


    /**
     * 根据户主id查询户主基本信息
     * @param request
     * @param response
     * @param userId
     * @return
     */
    @RequestMapping(value = "/mm/selectByUserId",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData selectByUserId(HttpServletRequest request, HttpServletResponse response,@RequestParam Long userId){

        List<UserInfo> userInfoList = new ArrayList<UserInfo>();
        UserInfo userInfo = userInfoService.selectByUserId(userId);
        userInfoList.add(userInfo);
        return new ResponseData(userInfoList);
    }


    /**
     * 保存/更新常住成员的信息
     * @param userMembers
     * @return
     */
    @RequestMapping(value = "/mm/saveUserMember",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData saveUserInfo(HttpServletRequest request, HttpServletResponse response,@RequestBody List<UserMember> userMembers){
        userInfoService.insertUserMember(userMembers);
        return new ResponseData();

    }

    /**
     * 保存常住成员的信息
     * @param userMembers
     * @return
     */
    @RequestMapping(value = "/mm/addUserMember",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData addUserInfo(HttpServletRequest request, HttpServletResponse response,@RequestBody List<UserMember> userMembers ,@RequestParam Long userId){
        for(UserMember userMember:userMembers){
            userMember.setUserId(userId);
        }
        userInfoService.insertUserMember(userMembers);
        return new ResponseData();

    }

    /**
     * 查询所有常住人员
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/mm/selectAllUserMember",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData selectAllUserInfo(HttpServletRequest request, HttpServletResponse response){
       return new ResponseData(userInfoService.selectAllUserMember());
    }

    /**
     * 根据户主id查询常住人员
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/mm/selectMemberByUserId",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData selectUserMemberByUserId(HttpServletRequest request, HttpServletResponse response,@RequestParam Long userId){
        return new ResponseData(userInfoService.selectMemberByUserId(userId));
    }



    /**
     * 删除根据id常住人员
     * @param request
     * @param response
     * @param userMemberList
     * @return
     */
    @RequestMapping(value = "/mm/deteleUserMember",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData deteleUserInfo(HttpServletRequest request, HttpServletResponse response,@RequestBody List<UserMember> userMemberList){

        userInfoService.deleteById(userMemberList);
        return new ResponseData(userInfoService.selectAllUserMember());
    }

    /**
     * 添加或者更新房屋信息
     * @param request
     * @param response
     * @param buildingInfo
     * @return
     */
    @RequestMapping(value = "/mm/insertBuildingInfo",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData insertBuildingInfo(HttpServletRequest request, HttpServletResponse response,@RequestBody BuildingInfo buildingInfo){

        userInfoService.insertBuildingInfo(buildingInfo);
        return new ResponseData();
    }

    /**
     * 根据户主id查询房屋信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/mm/selectBuildById",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData selectBuildById(HttpServletRequest request, HttpServletResponse response,@RequestParam Long userId){

        BuildingInfo buildingInfo = userInfoService.selectBuildById(userId);
        List<BuildingInfo> buildingInfoList = new ArrayList<BuildingInfo>();
        buildingInfoList.add(buildingInfo);
        return new ResponseData(buildingInfoList);
    }

    /**
     * 查询所有户主信息列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/mm/queryAllUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData queryAllUserInfo(HttpServletRequest request, HttpServletResponse response){
        QueryUserInfo queryUserInfo = new QueryUserInfo();
        List<QueryUserInfo> queryAllUserInfo = userInfoService.queryAllUserInfo(queryUserInfo);

        return new ResponseData(queryAllUserInfo);
    }
    /**
     * 查询所有户主信息列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/mm/queryAllUserInfo11",method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseData queryAllUserInfo11(HttpServletRequest request, HttpServletResponse response,@RequestBody QueryUserInfo queryUserInfo){

        List<QueryUserInfo> queryAllUserInfo = userInfoService.queryAllUserInfo(queryUserInfo);

        return new ResponseData(queryAllUserInfo);
    }

    /**
     * 查询所有的房屋类型
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/mm/selectAllType",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData selectAllType(HttpServletRequest request, HttpServletResponse response){

        List<BuildingType> BuildingTypes = userInfoService.selectAllType();

        return new ResponseData(BuildingTypes);
    }


}
