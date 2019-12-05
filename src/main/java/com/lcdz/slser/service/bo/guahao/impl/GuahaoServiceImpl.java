package com.lcdz.slser.service.bo.guahao.impl;

import com.lcdz.slser.service.bo.guahao.GuahaoService;
import com.lcdz.slser.service.dao.guahao.GuahaoDao;
import com.lcdz.slser.tools.exception.ReException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2019/12/5 18:34
 */

@Service
@Slf4j
@Transactional
public class GuahaoServiceImpl implements GuahaoService {


    @Autowired
    private GuahaoDao guahaoDao;


    @Override
    public List<Map<String, String>> getKs(Map<String, String> map) {
        try{
            List<Map<String,String>> list = guahaoDao.getKs(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询挂号科室列表出错】" + e.getMessage());
            throw new ReException("查询挂号科室列表失败");
        }
    }

    @Override
    public List<Map<String, String>> getDoc(Map<String, String> map) {
        try{
            List<Map<String,String>> list = guahaoDao.getDoc(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询挂号医生列表出错】" + e.getMessage());
            throw new ReException("查询挂号医生列表失败");
        }
    }

    @Override
    public List<Map<String, String>> getDocPb(Map<String, String> map) {
        try{
            List<Map<String,String>> list = guahaoDao.getDocPb(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询挂号医生排班列表出错】" + e.getMessage());
            throw new ReException("查询挂号医生排班列表失败");
        }
    }

    @Override
    public List<Map<String, String>> getGuahao(Map<String, String> map) {
        try{
            List<Map<String,String>> list = guahaoDao.getGuahao(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询我的挂号列表出错】" + e.getMessage());
            throw new ReException("查询我的预约列表失败");
        }
    }
}
