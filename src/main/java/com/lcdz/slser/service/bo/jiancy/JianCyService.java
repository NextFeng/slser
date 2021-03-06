package com.lcdz.slser.service.bo.jiancy;

import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2019/12/6 8:54
 */
public interface JianCyService {


    /**
     * 查询检验信息
     * @param map
     * @return
     */
    List<Map<String,String>> getjy(Map<String,String> map);

    /**
     * 查询检验信息明细
     * @param map
     * @return
     */
    List<Map<String,String>> getjymx(Map<String,String> map);

    /**
     * 查询检查信息
     * @param map
     * @return
     */
    List<Map<String,String>> getjc(Map<String,String> map);

    /**
     * 查询检查信息明细
     * @param map
     * @return
     */
    Map<String,String> getjcmx(Map<String,String> map);

}
