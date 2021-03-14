package com.lcdz.slser.service.bo.dzph.impl;

import com.lcdz.slser.service.bo.dzph.DzphService;
import com.lcdz.slser.service.dao.dzph.DzphDao;
import com.lcdz.slser.tools.exception.ReException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author qzg
 * @version 1.0
 * @date 2021-3-13 21:14
 */


@Slf4j
@Service
public class DzphServiceImpl implements DzphService {


    @Autowired
    private DzphDao dzphDao;


    @Override
    public Map<String, String> dzphCheck(Map<String, String> map) {
        try{
            dzphDao.dzphCheck(map);
            if("SUCCESS".equals(map.get("RETURNCODE"))){
                return map;
            }else{
                log.error("【电子陪护证验证失败】参数+ " + map);
                throw new ReException("电子陪护证验证调用存储过程返回失败：" + map.get("RETURNMSG"));
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("【电子陪护证验证出错】" + e.getMessage());
            throw new ReException("电子陪护证验证失败");
        }
    }


}
