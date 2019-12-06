package com.lcdz.slser.service.bo.zycx.impl;

import com.lcdz.slser.service.bo.zycx.ZycxService;
import com.lcdz.slser.service.dao.zycx.ZycxDao;
import com.lcdz.slser.tools.exception.ReException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2019/12/6 10:37
 */

@Service
@Slf4j
@Transactional
public class ZycxServiceImpl implements ZycxService {

    @Autowired
    private ZycxDao zycxDao;


    @Override
    public List<Map<String, String>> getzyCards(Map<String, String> map) {
        try{
            List<Map<String,String>> list = zycxDao.getzyCards(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询住院号列表出错】" + e.getMessage());
            throw new ReException("查询住院号列表失败");
        }
    }

    @Override
    public List<Map<String, String>> getzyBill(Map<String, String> map) {
        try{
            List<Map<String,String>> list = zycxDao.getzyBill(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询住院充值记录列表出错】" + e.getMessage());
            throw new ReException("查询住院充值记录列表失败");
        }
    }

    @Override
    public List<Map<String, String>> getzyZd(Map<String, String> map) {
        try{
            List<Map<String,String>> list = zycxDao.getzyZd(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询住院账单列表出错】" + e.getMessage());
            throw new ReException("查询住院账单列表失败");
        }
    }

    @Override
    public List<Map<String, String>> getzyZdmx(Map<String, String> map) {
        try{
            List<Map<String,String>> list = zycxDao.getzyZdmx(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询住院账单明细列表出错】" + e.getMessage());
            throw new ReException("查询住院账单明细列表失败");
        }
    }
}
