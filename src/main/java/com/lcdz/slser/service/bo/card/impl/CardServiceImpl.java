package com.lcdz.slser.service.bo.card.impl;

import com.lcdz.slser.service.bo.card.CardService;
import com.lcdz.slser.service.dao.card.CardDao;
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
 * @date 2019/12/3 13:29
 */

@Service
@Slf4j
@Transactional
public class CardServiceImpl implements CardService {


    @Autowired
    private CardDao cardDao;


    @Override
    public List<Map<String, String>> getCards(Map<String, String> map) {
        try{
            List<Map<String,String>> list = cardDao.getCards(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询患者信息查询卡列表出错】" + e.getMessage());
            throw new ReException("查询卡列表失败");
        }
    }

    @Override
    public String getCharge(String cardID) {
        try{
            Map<String,Object> map = cardDao.getCharge(cardID);
            return String.valueOf(map.get("MONEY"));
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询患者卡余额出错】" + e.getMessage());
            throw new ReException("查询患者卡余额失败");
        }
    }

    @Override
    public List<Map<String, String>> getBill(Map<String, String> map) {
        try{
            List<Map<String,String>> list = cardDao.getBill(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询患者就诊卡账单出错】" + e.getMessage());
            throw new ReException("查询患者就诊卡账单失败");
        }
    }

    @Override
    public Map<String, String> addCard(Map<String, String> map) {
        try{
            cardDao.addCard(map);
            if("SUCCESS".equals(map.get("RETURNCODE"))){
                Map<String,String> remap = new HashMap<>();
                remap.put("CARDNO",map.get("CARDNO"));
                return remap;
            }else{
                log.error("【创建就诊卡失败】参数+ " + map);
                throw new ReException("创建就诊卡调用存储过程返回失败：" + map.get("RETURNMSG"));
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("【创建就诊卡出错】" + e.getMessage());
            throw new ReException("创建就诊卡失败");
        }
    }

    @Override
    public Map<String, String> chargeCard(Map<String, String> map) {
        try{
            cardDao.chargeCard(map);
            if("SUCCESS".equals(map.get("RETURNCODE"))){
                Map<String,String> remap = new HashMap<>();
                remap.put("MONEY",map.get("MONEY"));
                return remap;
            }else{
                log.error("【就诊卡充值失败】参数+ " + map);
                throw new ReException("就诊卡充值调用存储过程返回失败：" + map.get("RETURNMSG"));
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("【就诊卡充值出错】" + e.getMessage());
            throw new ReException("就诊卡充值失败");
        }
    }
}
