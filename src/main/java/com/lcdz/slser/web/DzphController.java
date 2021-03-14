package com.lcdz.slser.web;

import com.lcdz.slser.service.bo.dzph.DzphService;
import com.lcdz.slser.tools.exception.ReException;
import com.lcdz.slser.tools.result.ResUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author qzg
 * @version 1.0
 * @date 2021-3-13 21:18
 */

@Slf4j
@Component
public class DzphController {


    @Autowired
    private DzphService dzphService;

    /**
     * 电子陪护证验证
     * @param map
     */
    public String dzphCheck(Map<String,String> map){
        try{
            dzphService.dzphCheck(map);
            return ResUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【电子陪护证验证出错】" + e.getMessage());
            throw new ReException("电子陪护证验证失败");
        }
    }


}
