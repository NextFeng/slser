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
     * 查询检验信息明细
     * @param map
     * @return
     */
    List<Map<String,String>> getjymx(Map<String,String> map);
}
