package com.pm.dsis.fee.job;

import com.pm.dsis.fee.service.PmFeeService;
import com.pm.dsis.fee.service.serviceImpl.PmFeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2018/4/6.
 */

public class PmFeeJob {

    @Autowired
    private PmFeeService pmFeeService;

    public void insertPmFee(){
        System.out.println("job begin");
        //pmFeeService.insert();
        System.out.println("job end");
    }


    public void say (){
        System.out.println("hello world");
    }

}
