package com.lcdz.slser.service.bo.card.impl;

import com.lcdz.slser.service.bo.card.CardService;
import com.lcdz.slser.service.dao.card.CardDao;
import com.lcdz.slser.tools.exception.ReException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
            Map<String,String> map = cardDao.getCharge(cardID);
            return map.get("MONEY");
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
}
