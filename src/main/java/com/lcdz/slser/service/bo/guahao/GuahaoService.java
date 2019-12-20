package com.lcdz.slser.service.bo.guahao;

import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2019/12/5 18:33
 */
public interface GuahaoService {

    /**
     * 查询挂号的科室信息
     * @param map
     * @return 科室列表
     */
    List<Map<String,String>> getKs(Map<String,String> map);


    /**
     * 查询挂号的医生信息
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
     * 查询我的挂号
     * @param map
     * @return 挂号信息
     */
    List<Map<String,String>> getGuahao(Map<String,String> map);

    /**
     * 生成挂号信息
     * @param map
     */
    Map<String,String> addGuahao(Map<String,String> map);


    /**
     * 取消挂号
     * @param map
     */
    Map<String,String> deGuahao(Map<String,String> map);



}
