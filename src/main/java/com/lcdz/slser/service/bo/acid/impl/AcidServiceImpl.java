package com.lcdz.slser.service.bo.acid.impl;

import com.lcdz.slser.service.bo.acid.AcidService;
import com.lcdz.slser.service.dao.acid.AcidDao;
import com.lcdz.slser.tools.exception.ReException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2021-02-18 22:30
 */

@Service
@Slf4j
@Transactional
public class AcidServiceImpl implements AcidService {

    @Autowired
    private AcidDao acidDao;


    @Override
    public List<Map<String, String>> getItems(Map<String, String> map) {
        try{
            List<Map<String,String>> list = acidDao.getItems(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询预约项目出错】" + e.getMessage());
            throw new ReException("查询预约项目失败");
        }
    }

    @Override
    public void addAcid(Map<String, String> map) {
        try{
            acidDao.addAcid(map);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【预约核酸检测出错】" + e.getMessage());
            throw new ReException("预约核酸检测失败");
        }
    }

    @Override
    public void calAcid(Map<String, String> map) {
        try{
            acidDao.calAcid(map);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【取消预约核酸检测出错】" + e.getMessage());
            throw new ReException("取消预约核酸检测失败");
        }
    }

    @Override
    public List<Map<String, String>> getYy(Map<String, String> map) {
        try{
            List<Map<String,String>> list = acidDao.getYy(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询预约记录出错】" + e.getMessage());
            throw new ReException("查询预约记录失败");
        }
    }
}
