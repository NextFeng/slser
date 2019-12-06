package com.lcdz.slser.web;

import com.lcdz.slser.service.bo.yuyue.YuyueService;
import com.lcdz.slser.tools.exception.ReException;
import com.lcdz.slser.tools.result.ResUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2019/12/6 11:11
 */
@Slf4j
@Component
public class YuyueController {

    @Autowired
    private YuyueService yuyueService;

    /**
     * 查询预约科室信息
     * @param map
     * @return 科室列表
     */
    public String yuyueKs(Map<String,String> map){
        try{
            List<Map<String,String>> list = yuyueService.getKs(map);
            return ResUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询预约科室列表出错】" + e.getMessage());
            throw new ReException("查询预约科室列表失败");
        }
    }

    /**
     * 查询预约医生信息
     * @param map
     * @return 医生列表
     */
    public String yuyueDoc(Map<String,String> map){
        try{
            List<Map<String,String>> list = yuyueService.getDoc(map);
            return ResUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询预约医生列表出错】" + e.getMessage());
            throw new ReException("查询预约医生列表失败");
        }
    }


    /**
     * 查询预约医生排班信息
     * @param map
     * @return 医生平排班列表
     */
    public String yuyuePb(Map<String,String> map){
        try{
            List<Map<String,String>> list = yuyueService.getDocPb(map);
            return ResUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询预约医生排班列表出错】" + e.getMessage());
            throw new ReException("查询预约医生排班列表失败");
        }
    }

    /**
     * 查询我的预约列表
     * @param map
     * @return 预约列表
     */
    public String yuyueList(Map<String,String> map){
        try{
            List<Map<String,String>> list = yuyueService.getYuyue(map);
            return ResUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询我的预约列表出错】" + e.getMessage());
            throw new ReException("查询我的预约列表失败");
        }
    }






}
