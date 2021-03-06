package com.lcdz.slser.service.dao.refund;


import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RefundDao {


    /**
     * 查询公众号的充值记录
     * @param map
     * @return
     */
    List<Map<String,String>> getwxlist(Map<String,String> map);



    /**
     * 检查退费金额
     * @param map
     * @return
     */
    void checkFee(Map<String,Object> map);



    /**
     * 进行退费
     * @param map
     * @return
     */
    void refund(Map<String,Object> map);




    /**
     * 查询线上退费记录
     * @param map
     * @return
     */
    List<Map<String, String>> refundList(Map<String,String> map);
}
