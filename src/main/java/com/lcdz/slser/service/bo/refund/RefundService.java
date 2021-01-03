package com.lcdz.slser.service.bo.refund;

import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2020-09-25 22:22
 */
public interface RefundService {


    /**
     * 查询公众号的充值记录
     * @param map
     * @return
     */
    List<Map<String,String>> getwxlist(Map<String,String> map);



    /**
     * 进行退费
     * @param map
     * @return
     */
    void refund(Map<String,String> map);




    /**
     * 查询线上退费记录
     * @param map
     * @return
     */
    List<Map<String, String>> refundList(Map<String,String> map);

}
