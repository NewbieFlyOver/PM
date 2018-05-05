package com.pm.dsis.repair.service.serviceImpl;

import com.pm.dsis.fee.dto.PmFee;
import com.pm.dsis.repair.dto.RepairInfo;
import com.pm.dsis.repair.mapper.RepairInfoMapper;
import com.pm.dsis.repair.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by admin on 2018/4/24.
 */
@Service
public class RepairServiceImpl implements RepairService{


    @Autowired
    private RepairInfoMapper repairInfoMapper;

    /**
     * 保存报修信息
     * @param record
     * @return
     */
    public int insertRepairInfo(RepairInfo record){
        return repairInfoMapper.insertRepairInfo(record);
    }

    /**
     * 条件查询
     * @param repairInfo
     * @return
     */
    public List<RepairInfo> selectRepairInfo(RepairInfo repairInfo){

        List<RepairInfo> repairInfoList =repairInfoMapper.selectRepairInfo(repairInfo);
        for (RepairInfo ri : repairInfoList) {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String bigenDateStr = sdf.format(ri.getRiDate());
            ri.setRiDateStr(bigenDateStr);
        }
        return repairInfoList;
    }

    /**
     * 更新报修信息
     * @param repairInfos
     * @return
     */
    public void updateRepairInfoById(List<RepairInfo> repairInfos) {
        for(RepairInfo ri:repairInfos) {
            repairInfoMapper.updateRepairInfoById(ri);
        }
    }
}
