package com.lcdz.slser.service.dao.dzph;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2019/12/3 12:16
 */
@Repository
public interface DzphDao {



    /**
     * 电子陪护证验证
     * @param map
     * @return 卡余额
     */
    void dzphCheck(Map<String, String> map);



}
