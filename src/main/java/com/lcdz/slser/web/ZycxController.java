package com.lcdz.slser.web;

import com.lcdz.slser.service.bo.zycx.ZycxService;
import com.lcdz.slser.tools.exception.ReException;
import com.lcdz.slser.tools.result.ResUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2019/12/6 11:48
 */

@Slf4j
@Component
public class ZycxController {


    @Autowired
    private ZycxService zycxService;

    /**
     * 查询住院号
     * @param map
     * @return 住院号列表
     */
    public String zyCards(Map<String,String> map){
        try{
            List<Map<String,String>> list = zycxService.getzyCards(map);
            return ResUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询住院号出错】" + e.getMessage());
            throw new ReException("查询住院号失败");
        }
    }

    /**
     * 查询住院缴费记录
     * @param map
     * @return 缴费记录
     */
    public String zyBill(Map<String,String> map){
        try{
            List<Map<String,String>> list = zycxService.getzyBill(map);
            return ResUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询住院缴费记录出错】" + e.getMessage());
            throw new ReException("查询住院缴费记录失败");
        }
    }


    /**
     * 查询住院账单
     * @param map
     * @return 账单列表
     */
    public String zyZd(Map<String,String> map){
        try{
            List<Map<String,String>> list = zycxService.getzyZd(map);
            return ResUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询住院账单出错】" + e.getMessage());
            throw new ReException("查询住院账单失败");
        }
    }

    /**
     * 查询住院账单明细
     * @param map
     * @return 账单明细列表
     */
    public String zyZdmx(Map<String,String> map){
        try{
            List<Map<String,String>> list = zycxService.getzyZdmx(map);
            return ResUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询住院明细账单出错】" + e.getMessage());
            throw new ReException("查询住院明细账单失败");
        }
    }



}
