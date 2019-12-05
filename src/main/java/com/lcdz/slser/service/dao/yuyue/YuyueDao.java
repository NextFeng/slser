package com.lcdz.slser.service.dao.yuyue;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2019/12/5 15:34
 */
@Repository
public interface YuyueDao {


    /**
     * 查询预约的科室信息
     * @param map
     * @return 科室列表
     */
    List<Map<String,String>> getKs(Map<String,String> map);


    /**
     * 查询预约的医生信息
     * @param map
     * @return 医生列表
     */
    List<Map<String,String>> getDoc(Map<String,String> map);



    /**
     * 查询医生排班信息
     * @param map
     * @return 排班信息
     */
    List<Map<String,String>> getDocPb(Map<String,String> map);


    /**
     * 查询我的预约
     * @param map
     * @return 预约信息
     */
    List<Map<String,String>> getYuyue(Map<String,String> map);
}
