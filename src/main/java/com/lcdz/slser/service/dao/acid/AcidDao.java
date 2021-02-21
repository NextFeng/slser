package com.lcdz.slser.service.dao.acid;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2019/12/3 12:16
 */

@Repository
public interface AcidDao {

    /**
     * 查询预约的项目
     * @param map
     * @return 卡列表
     */
    List<Map<String,String>> getItems(Map<String, String> map);


    /**
     * 预约
     * @param map
     * @return
     */
    void addAcid(Map<String, String> map);



    /**
     * 取消预约
     * @param map
     * @return
     */
    void calAcid(Map<String, String> map);



}
