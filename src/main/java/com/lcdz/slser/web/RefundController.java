package com.lcdz.slser.web;


import com.lcdz.slser.service.bo.refund.RefundService;
import com.lcdz.slser.tools.exception.ReException;
import com.lcdz.slser.tools.result.ResUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class RefundController {

    @Autowired
    private RefundService refundService;


    /**
     * 查询微信充值记录
     * @param map
     * @return
     */
    public String getwxlist(Map<String,String> map){
        try{
            List<Map<String,String>> list = refundService.getwxlist(map);
            return ResUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询微信充值记录出错】" + e.getMessage());
            throw new ReException("查询微信充值记录出错");
        }
    }



    /**
     * 进行退款
     * @param map
     * @return
     */
    public String refund(Map<String,String> map){
        try{
            refundService.refund(map);
            return ResUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【充值退款出错】" + e.getMessage());
            throw new ReException("充值退款出错");
        }
    }






    /**
     * 查询微信退费记录
     * @param map
     * @return
     */
    public String refundList(Map<String,String> map){
        try{
            List<Map<String,String>> list = refundService.refundList(map);
            return ResUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询微信退费记录出错】" + e.getMessage());
            throw new ReException("查询微信退费记录出错");
        }
    }

}
