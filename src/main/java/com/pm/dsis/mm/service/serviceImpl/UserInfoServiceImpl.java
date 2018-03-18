package com.pm.dsis.mm.service.serviceImpl;

import com.pm.dsis.mm.dto.UserInfo;

import com.pm.dsis.mm.dto.UserMember;
import com.pm.dsis.mm.mapper.UserInfoMapper;
import com.pm.dsis.mm.mapper.UserMemberMapper;
import com.pm.dsis.mm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by admin on 2018/3/18.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserMemberMapper userMemberMapper;


    public int insertUserInfo(UserInfo userInfo){
        return userInfoMapper.insertUserInfo(userInfo);
    }

    @Transactional
    public void insertUserMember(List<UserMember> userMemberList){

        for (UserMember userMember:userMemberList) {
            Long id = userMember.getMemberId();
            if("".equals(id)||null==id ){
                userMemberMapper.insertUserMember(userMember);
            }else{
                userMemberMapper.updateUserMember(userMember);
            }

        }
    }


    public List<UserMember> selectAllUserMember(){
        return userMemberMapper.selectAllUserMember();
    }

    public void deleteById(List<UserMember> userMemberList){

        for (UserMember userMember:userMemberList) {
            userMemberMapper.deleteById(userMember.getMemberId());
        }
    }

}
