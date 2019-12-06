package com.lcdz.slser.service.bo.hosp.impl;

import com.lcdz.slser.service.bo.hosp.TelService;
import com.lcdz.slser.service.dao.hosp.TelDao;
import com.lcdz.slser.tools.exception.ReException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2019/12/6 12:00
 */

@Service
@Slf4j
@Transactional
public class TelServiceImpl implements TelService {

    @Autowired
    private TelDao telDao;

    @Override
    public List<Map<String, String>> getDocInfo(Map<String, String> map) {
        try{
            List<Map<String,String>> list = telDao.getDocInfo(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询医院医生信息出错】" + e.getMessage());
            throw new ReException("查询医院医生信息失败");
        }
    }
}
