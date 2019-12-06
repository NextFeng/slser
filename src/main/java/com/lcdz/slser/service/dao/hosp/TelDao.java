package com.lcdz.slser.service.dao.hosp;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2019/12/6 11:57
 */
@Repository
public interface TelDao {


    /**
     * 查询医院医生信息
     * @param map
     * @return 医生信息列表
     */
    List<Map<String,String>> getDocInfo(Map<String,String> map);


}
