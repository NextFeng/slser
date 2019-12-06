package com.lcdz.slser.web;

import com.lcdz.slser.service.bo.hosp.TelService;
import com.lcdz.slser.tools.exception.ReException;
import com.lcdz.slser.tools.result.ResUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2019/12/6 12:05
 */
@Slf4j
@Component
public class HospController {


    @Autowired
    private TelService telService;

    /**
     * 查询医院医生信息
     * @param map
     * @return 医生列表
     */
    public String docInfo(Map<String,String> map){
        try{
            List<Map<String,String>> list = telService.getDocInfo(map);
            return ResUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询医院医生信息出错】" + e.getMessage());
            throw new ReException("查询医院医生信息失败");
        }
    }

}
