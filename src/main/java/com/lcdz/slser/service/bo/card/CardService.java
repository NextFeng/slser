package com.lcdz.slser.service.bo.card;

import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2019/12/3 13:29
 */
public interface CardService {

    /**
     * 根据姓名、身份证号、手机号查询院内卡
     * @param map
     * @return 卡列表
     */
    List<Map<String,String>> getCards(Map<String,String> map);


    /**
     * 查询就诊卡余额
     * @param cardID
     * @return 卡信息
     */
    String getCharge(String cardID);

    /**
     * 查询就诊卡账单
     * @param map
     * @return 卡列表
     */
    List<Map<String,String>> getBill(Map<String,String> map);

    /**
     * 添加就诊卡
     * @param map
     * @return
     */
    Map<String,String> addCard(Map<String,String> map);



    /**
     * 就诊卡充值
     * @param map
     * @return 卡余额
     */
    Map<String,String> chargeCard(Map<String,String> map);

}
