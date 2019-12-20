package com.lcdz.slser.service.bo.zycx;

import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2019/12/6 10:36
 */
public interface ZycxService {

    /**
     * 根据姓名、身份证号、手机号查询住院号
     * @param map
     * @return 住院号列表
     */
    List<Map<String,String>> getzyCards(Map<String,String> map);


    /**
     * 查询住院缴费记录
     * @param map
     * @return 缴费记录
     */
    List<Map<String,String>> getzyBill(Map<String,String> map);


    /**
     * 查询住院账单
     * @param map
     * @return 消费记录
     */
    List<Map<String,String>> getzyZd(Map<String,String> map);


    /**
     * 查询住院账单明细
     * @param map
     * @return 账单明细
     */
    List<Map<String,String>> getzyZdmx(Map<String,String> map);


    /**
     * 住院押金充值
     * @param map
     * @return 押金余额
     */
    Map<String,String> zycz(Map<String,String> map);

}
