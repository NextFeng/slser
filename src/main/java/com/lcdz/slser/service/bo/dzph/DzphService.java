package com.lcdz.slser.service.bo.dzph;

import java.util.Map;

/**
 * @author qzg
 * @version 1.0
 * @date 2021-3-13 21:13
 */
public interface DzphService {

    /**
     * 电子陪护证验证
     * @param map
     * @return 卡余额
     */
    Map<String, String> dzphCheck(Map<String, String> map);

}
