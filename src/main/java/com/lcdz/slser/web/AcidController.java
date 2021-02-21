package com.lcdz.slser.web;

import com.lcdz.slser.service.bo.acid.AcidService;
import com.lcdz.slser.tools.exception.ReException;
import com.lcdz.slser.tools.result.ResUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2021-02-18 22:26
 */

@Slf4j
@Component
public class AcidController {

    @Autowired
    private AcidService acidService;


    /**
     * 查询预约的项目
     * @param map
     * @return 项目列表
     */
    public String getItems(Map<String,String> map){
        try{
            List<Map<String,String>> list = acidService.getItems(map);
            return ResUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询预约的项目出错】" + e.getMessage());
            throw new ReException("查询预约的项目失败");
        }
    }



    /**
     * 预约核酸检测
     * @param map
     * @return
     */
    public String addAcid(Map<String,String> map){
        try{
            acidService.addAcid(map);
            return ResUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【预约核酸检测出错】" + e.getMessage());
            throw new ReException("预约核酸检测失败");
        }
    }


    /**
     * 取消预约核酸检测
     * @param map
     * @return
     */
    public String calAcid(Map<String,String> map){
        try{
            acidService.calAcid(map);
            return ResUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【取消预约核酸检测出错】" + e.getMessage());
            throw new ReException("取消预约核酸检测失败");
        }
    }

}
