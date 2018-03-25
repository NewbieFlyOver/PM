package com.pm.dsis.mm.mapper;

import com.pm.dsis.mm.dto.UserMember;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMemberMapper {

    int updateUserMember(UserMember userMember);

    int insertUserMember(UserMember userMember);

    List<UserMember> selectUserMember(UserMember userMember);

    List<UserMember> selectAllUserMember();

    List<UserMember> selectMemberByUserId(Long userId);





    int insertSelective(UserMember record);

    int updateByPrimaryKeySelective(UserMember record);

    int deleteById(Long memberId);
}