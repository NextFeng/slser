package com.lcdz.slser.web;

import com.lcdz.slser.service.bo.jiancy.JianCyService;
import com.lcdz.slser.tools.exception.ReException;
import com.lcdz.slser.tools.result.ResUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2019/12/6 11:37
 */
@Slf4j
@Component
public class JiancyController {



    @Autowired
    private JianCyService jianCyService;

    /**
     * 查询检查列表信息
     * @param map
     * @return 检查列表
     */
    public String jcList(Map<String,String> map){
        try{
            List<Map<String,String>> list = jianCyService.getjc(map);
            return ResUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询检查列表信息出错】" + e.getMessage());
            throw new ReException("查询检查列表信息失败");
        }
    }

    /**
     * 查询检查明细列表信息
     * @param map
     * @return 检查列表
     */
    public String jcmxInfo(Map<String,String> map){
        try{
            Map<String,String> remap  = jianCyService.getjcmx(map);
            return ResUtil.success(remap);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询检查明细信息出错】" + e.getMessage());
            throw new ReException("查询检查明细信息失败");
        }
    }



    /**
     * 查询检验列表信息
     * @param map
     * @return 检验列表
     */
    public String jyList(Map<String,String> map){
        try{
            List<Map<String,String>> list = jianCyService.getjy(map);
            return ResUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询检验列表信息出错】" + e.getMessage());
            throw new ReException("查询检验列表信息失败");
        }
    }

    /**
     * 查询检验明细列表信息
     * @param map
     * @return 检验明细列表
     */
    public String jymxList(Map<String,String> map){
        try{
            List<Map<String,String>> list = jianCyService.getjymx(map);
            return ResUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询检验明细列表信息出错】" + e.getMessage());
            throw new ReException("查询检验明细列表信息失败");
        }
    }




}
