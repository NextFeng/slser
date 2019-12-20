package com.lcdz.slser.service.bo.guahao.impl;

import com.lcdz.slser.service.bo.guahao.GuahaoService;
import com.lcdz.slser.service.dao.guahao.GuahaoDao;
import com.lcdz.slser.tools.exception.ReException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
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

    @Override
    public Map<String, String> addGuahao(Map<String, String> map) {
        try{
            guahaoDao.addGuahao(map);
            if("SUCCESS".equals(map.get("RETURNCODE"))){
                Map<String,String> remap = new HashMap<>();
                remap.put("GHNO",map.get("GHNO"));
                return remap;
            }else{
                log.error("【生成挂号信息失败】参数+ " + map);
                throw new ReException("生成挂号信息调用存储过程返回失败：" + map.get("RETURNMSG"));
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("【生成挂号信息出错】" + e.getMessage());
            throw new ReException("生成挂号信息失败");
        }
    }

    @Override
    public Map<String, String> deGuahao(Map<String, String> map) {
        try{
            guahaoDao.deGuahao(map);
            if("SUCCESS".equals(map.get("RETURNCODE"))){
                return new HashMap<>();
            }else{
                log.error("【取消挂号失败】参数+ " + map);
                throw new ReException("取消挂号调用存储过程返回失败：" + map.get("RETURNMSG"));
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("【取消挂号出错】" + e.getMessage());
            throw new ReException("取消挂号失败");
        }
    }
}
