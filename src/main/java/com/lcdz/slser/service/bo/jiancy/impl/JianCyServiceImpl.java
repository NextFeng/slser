package com.lcdz.slser.service.bo.jiancy.impl;

import com.lcdz.slser.service.bo.jiancy.JianCyService;
import com.lcdz.slser.service.dao.jiancy.JianCyDao;
import com.lcdz.slser.tools.exception.ReException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2019/12/6 8:58
 */

@Service
@Slf4j
@Transactional
public class JianCyServiceImpl implements JianCyService {


    @Autowired
    private JianCyDao jianCyDao;


    @Override
    public List<Map<String, String>> getjy(Map<String, String> map) {
        try{
            List<Map<String,String>> list = jianCyDao.getjy(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询检验列表出错】" + e.getMessage());
            throw new ReException("查询检验列表失败");
        }
    }

    @Override
    public List<Map<String, String>> getjymx(Map<String, String> map) {
        try{
            List<Map<String,String>> list = jianCyDao.getjymx(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询检验明细列表出错】" + e.getMessage());
            throw new ReException("查询检验明细列表失败");
        }
    }

    @Override
    public List<Map<String, String>> getjc(Map<String, String> map) {
        try{
            List<Map<String,String>> list = jianCyDao.getjc(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询检查列表出错】" + e.getMessage());
            throw new ReException("查询检查列表失败");
        }
    }

    @Override
    public Map<String, String> getjcmx(Map<String, String> map) {
        try{
            List<Map<String,String>> list = jianCyDao.getjcmx(map);
            if(list != null && list.size()>0){
                return list.get(0);
            }else{
                throw new ReException("查询检查明细列表失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询检查明细列表出错】" + e.getMessage());
            throw new ReException("查询检查明细列表失败");
        }
    }
}
