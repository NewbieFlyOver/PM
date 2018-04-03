package com.pm.dsis.common.mapper;

import com.pm.dsis.common.dto.CommonInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by admin on 2018/4/2.
 */
public interface CommonInfoMapper {

    List<CommonInfo> selectByType(@Param("commonType") String commonType);
}
