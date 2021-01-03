package com.lcdz.slser.service.bo.refund.impl;

import com.lcdz.slser.service.bo.refund.RefundService;
import com.lcdz.slser.service.dao.refund.RefundDao;
import com.lcdz.slser.tools.exception.ReException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2020-09-25 22:22
 */

@Service
@Slf4j
@Transactional
public class RefundServiceImpl implements RefundService {

    @Autowired
    private RefundDao refundDao;

    @Override
    public List<Map<String, String>> getwxlist(Map<String, String> map) {
        try{
            List<Map<String,String>> list = refundDao.getwxlist(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询微信充值列表出错】" + e.getMessage());
            throw new ReException("查询微信充值列表失败");
        }
    }

    @Override
    public void refund(Map<String, String> map) {
        try{
            Map<String,Object> checkMap = new HashMap<>();
            checkMap.put("病人id_in",map.get("CARDNO"));
            checkMap.put("金额_in",map.get("TOTALFEE"));
            refundDao.checkFee(checkMap);
            if("病人余额大于输入金额,可以退款！".equals(checkMap.get("result"))){
                Map<String,Object> refundMap = new HashMap<>();
                refundMap.put("CARDNO",map.get("CARDNO"));
                refundMap.put("TOTALFEE",map.get("TOTALFEE"));
                refundMap.put("LSH",map.get("LSH"));
                refundDao.refund(refundMap);
                if("数据写入失败！".equals(refundMap.get("result"))){
                    log.error("【进行退费失败】参数+ " + refundMap);
                    throw new ReException("进行退费失败：" + refundMap.get("result"));
                }else{
                  log.info(String.valueOf(refundMap.get("result")));
                }
            }else{
                log.error("【验证退费金额失败】参数+ " + checkMap);
                throw new ReException("验证退费金额失败：" + checkMap.get("result"));
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("【退费失败】" + e.getMessage());
            throw new ReException("退费失败" + e.getMessage());
        }

    }

    @Override
    public List<Map<String, String>> refundList(Map<String, String> map) {
        try{
            List<Map<String,String>> list = refundDao.refundList(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            log.error("【查询微信退费列表出错】" + e.getMessage());
            throw new ReException("查询微信退费列表失败");
        }
    }
}
