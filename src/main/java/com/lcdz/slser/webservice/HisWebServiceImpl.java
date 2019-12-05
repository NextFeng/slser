package com.lcdz.slser.webservice;

import com.lcdz.slser.tools.entity.MethodConstants;
import com.lcdz.slser.tools.exception.ReException;
import com.lcdz.slser.tools.result.ResUtil;
import com.lcdz.slser.tools.utils.WebUtils;
import com.lcdz.slser.tools.utils.XmlUtil;
import com.lcdz.slser.web.CardController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.jws.WebService;
import java.util.Map;

/**
 * @author QinZhenGuo
 * @date 2018/8/2 8:52
 */

@WebService(serviceName = "his", targetNamespace = "http://com.lcdz.his/")
@Component
@Slf4j
public class HisWebServiceImpl implements HisWebService {


    @Autowired
    private CardController cardController;


    @Override
    public String hiser(String message) {
        log.info("--------------------------------------------------【调用开始，当前时间是：" + WebUtils.getDateTime() + "】--------------------------------------------------");
        log.info("【当前时间是" + WebUtils.getDateTime() + ",收到的Xml是】:" + message.replaceAll("[\b\r\n\t]*", ""));
        String returnXml = "";
        try {
            Map<String, String> pamap = XmlUtil.xmlToMap(message);
//            if(!ParamUtil.checkSgin(pamap)){
//                throw new ReException("验证签名错误");
//            }
            String payMethod  = pamap.get("Method");
            if (MethodConstants.v_mz_cards.equals(payMethod)) {
                returnXml = cardController.MzCards(pamap);
            }else if(MethodConstants.proce_mz_create.equals(payMethod)){
                //
            }else if(MethodConstants.proce_mz_charge.equals(payMethod)){

            }else if(MethodConstants.v_mz_charge.equals(payMethod)){
                returnXml = cardController.MzCardCharge(pamap);
            }else if(MethodConstants.v_mz_bill.equals(payMethod)){
                returnXml = cardController.MzCardBill(pamap);
            }else if(MethodConstants.v_mz_ks.equals(payMethod)){

            }else if(MethodConstants.v_mz_doc.equals(payMethod)){

            }else if(MethodConstants.v_mz_yypb.equals(payMethod)){

            }else if(MethodConstants.proce_mz_yue.equals(payMethod)){

            }else if(MethodConstants.v_mz_getyue.equals(payMethod)){

            }else if(MethodConstants.proce_mz_calyy.equals(payMethod)){

            }else if(MethodConstants.proce_mz_charge.equals(payMethod)){

            }else if(MethodConstants.proce_mz_charge.equals(payMethod)){

            }else if(MethodConstants.proce_mz_charge.equals(payMethod)){

            }else if(MethodConstants.proce_mz_charge.equals(payMethod)){

            }else if(MethodConstants.proce_mz_charge.equals(payMethod)){

            }else if(MethodConstants.proce_mz_charge.equals(payMethod)){

            }else if(MethodConstants.proce_mz_charge.equals(payMethod)){

            }else if(MethodConstants.proce_mz_charge.equals(payMethod)){

            }else if(MethodConstants.proce_mz_charge.equals(payMethod)){

            }else if(MethodConstants.proce_mz_charge.equals(payMethod)){

            }else if(MethodConstants.proce_mz_charge.equals(payMethod)){

            }else if(MethodConstants.proce_mz_charge.equals(payMethod)){

            }else if(MethodConstants.proce_mz_charge.equals(payMethod)){

            }else if(MethodConstants.proce_mz_charge.equals(payMethod)){

            }else if(MethodConstants.proce_mz_charge.equals(payMethod)){

            }else if(MethodConstants.proce_mz_charge.equals(payMethod)){

            }else if(MethodConstants.proce_mz_charge.equals(payMethod)){

            }else {
                throw new ReException("Method 方法名传入错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("【PayWebServiceImpl-->UnifiedPayment】" + e.getMessage());
            returnXml = ResUtil.error(e.getMessage());
        }
        log.info("【当前时间是" + WebUtils.getDateTime() + ",返回的Xml是】:" + returnXml);
        log.info("--------------------------------------------------【调用结束，当前时间是：" + WebUtils.getDateTime() + "】--------------------------------------------------");
        return returnXml;
    }


}
