package com.lcdz.slser.service.bo.hosp;

import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2019/12/6 12:00
 */
public interface TelService {

    /**
     * 查询医院医生信息
     * @param map
     * @return 医生信息列表
     */
    List<Map<String,String>> getDocInfo(Map<String,String> map);

}
