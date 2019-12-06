package com.lcdz.slser.web;

import com.lcdz.slser.service.bo.guahao.GuahaoService;
import com.lcdz.slser.tools.exception.ReException;
import com.lcdz.slser.tools.result.ResUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2019/12/6 11:31
 */

@Slf4j
@Component
public class GuahaoController {

    @Autowired
    private GuahaoService guahaoService;



    /**
     * 查询挂号科室信息
     * @param map
     * @return 科室列表
     */
    public String guahaoKs(Map<String,String> map){
        try{
            List<Map<String,String>> list = guahaoService.getKs(map);
            return ResUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询挂号科室列表出错】" + e.getMessage());
            throw new ReException("查询挂号科室列表失败");
        }
    }

    /**
     * 查询挂号医生信息
     * @param map
     * @return 医生列表
     */
    public String guahaoDoc(Map<String,String> map){
        try{
            List<Map<String,String>> list = guahaoService.getDoc(map);
            return ResUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询挂号医生列表出错】" + e.getMessage());
            throw new ReException("查询挂号医生列表失败");
        }
    }


    /**
     * 查询挂号医生排班信息
     * @param map
     * @return 医生排班列表
     */
    public String guahaoPb(Map<String,String> map){
        try{
            List<Map<String,String>> list = guahaoService.getDocPb(map);
            return ResUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询挂号医生排班列表出错】" + e.getMessage());
            throw new ReException("查询挂号医生排班列表失败");
        }
    }

    /**
     * 查询我的挂号列表
     * @param map
     * @return 挂号列表
     */
    public String guahaoList(Map<String,String> map){
        try{
            List<Map<String,String>> list = guahaoService.getGuahao(map);
            return ResUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询我的挂号列表出错】" + e.getMessage());
            throw new ReException("查询我的挂号列表失败");
        }
    }
}
