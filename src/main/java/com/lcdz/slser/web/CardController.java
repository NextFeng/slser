package com.lcdz.slser.web;

import com.lcdz.slser.service.bo.card.CardService;
import com.lcdz.slser.tools.exception.ReException;
import com.lcdz.slser.tools.result.ResUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2019/12/3 12:20
 */

@Slf4j
@Component
public class CardController {

    @Autowired
    private CardService cardService;


    /**
     * 根据个人信息查询名下就诊卡
     * @param map
     * @return 就诊卡列表
     */
    public String MzCards(Map<String,String> map){
        try{
            List<Map<String,String>> list = cardService.getCards(map);
            return ResUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询患者信息查询卡列表出错】" + e.getMessage());
            throw new ReException("查询卡列表失败");
        }
    }

    /**
     * 查询患者就诊卡账单
     * @param map
     * @return 账单列表
     */
    public String MzCardBill(Map<String,String> map){
        try{
            List<Map<String,String>> list = cardService.getBill(map);
            return ResUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询患者就诊卡账单出错】" + e.getMessage());
            throw new ReException("查询患者就诊卡账单失败");
        }
    }


    /**
     * 查询患者就诊卡余额
     * @param map
     * @return 账单列表
     */
    public String MzCardCharge(Map<String,String> map){
        try{
            String charge = cardService.getCharge(map.get("CARDNO"));
            map.clear();
            map.put("MONEY",charge);
            return ResUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询患者就诊卡账单出错】" + e.getMessage());
            throw new ReException("查询患者就诊卡账单失败");
        }
    }







}
