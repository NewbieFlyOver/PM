package com.pm.dsis.common.service.serviceImpl;

import com.pm.dsis.common.dto.CommonInfo;
import com.pm.dsis.common.mapper.CommonInfoMapper;
import com.pm.dsis.common.service.CommonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2018/4/2.
 */
@Service
public class CommonInfoServiceImpl implements CommonInfoService {

    @Autowired
    private CommonInfoMapper commonInfoMapper;


    public List<CommonInfo> selectByType(String commonType){
        return commonInfoMapper.selectByType(commonType);
    }
}
