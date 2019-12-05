package com.lcdz.slser.service.bo.yuyue.impl;

import com.lcdz.slser.service.bo.yuyue.YuyueService;
import com.lcdz.slser.service.dao.yuyue.YuyueDao;
import com.lcdz.slser.tools.exception.ReException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2019/12/5 15:38
 */

@Service
@Slf4j
@Transactional
public class YuyueServiceImpl implements YuyueService {

    @Autowired
    private YuyueDao yuyueDao;


    @Override
    public List<Map<String, String>> getKs(Map<String, String> map) {
        try{
            List<Map<String,String>> list = yuyueDao.getKs(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询预约科室列表出错】" + e.getMessage());
            throw new ReException("查询预约科室列表失败");
        }
    }

    @Override
    public List<Map<String, String>> getDoc(Map<String, String> map) {
        try{
            List<Map<String,String>> list = yuyueDao.getDoc(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询预约医生列表出错】" + e.getMessage());
            throw new ReException("查询预约医生列表失败");
        }
    }

    @Override
    public List<Map<String, String>> getDocPb(Map<String, String> map) {
        try{
            List<Map<String,String>> list = yuyueDao.getDocPb(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询预约医生排班列表出错】" + e.getMessage());
            throw new ReException("查询预约医生排班列表失败");
        }
    }

    @Override
    public List<Map<String, String>> getYuyue(Map<String, String> map) {
        try{
            List<Map<String,String>> list = yuyueDao.getYuyue(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询我的预约列表出错】" + e.getMessage());
            throw new ReException("查询我的预约列表失败");
        }
    }
}
