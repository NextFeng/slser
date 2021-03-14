package com.lcdz.slser.webservice;

import com.lcdz.slser.tools.entity.MethodConstants;
import com.lcdz.slser.tools.exception.ReException;
import com.lcdz.slser.tools.result.ResUtil;
import com.lcdz.slser.tools.utils.WebUtils;
import com.lcdz.slser.tools.utils.XmlUtil;
import com.lcdz.slser.web.*;
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

    @Autowired
    private YuyueController yuyueController;

    @Autowired
    private GuahaoController guahaoController;

    @Autowired
    private JiancyController jiancyController;

    @Autowired
    private ZycxController zycxController;

    @Autowired
    private HospController hospController;

    @Autowired
    private RefundController refundController;

    @Autowired
    private AcidController acidController;

    @Autowired
    private DzphController dzphController;


    @Override
    public String hiser(String message) {
        log.info("--------------------------------------------------【调用开始，当前时间是：" + WebUtils.getDateTime() + "】--------------------------------------------------");
        log.info("【当前时间是" + WebUtils.getDateTime() + ",收到的Xml是】:" + message.replaceAll("[\b\r\n\t]*", ""));
        String returnXml = "";
        try {
            Map<String, String> pamap = XmlUtil.xmlToMap(message);
            if(!ParamUtil.checkSgin(pamap)){
                throw new ReException("验证签名错误");
            }
            String payMethod  = pamap.get("Method");
            if (MethodConstants.v_mz_cards.equals(payMethod)) {
                //查询院内就诊卡
                returnXml = cardController.MzCards(pamap);
            }else if(MethodConstants.proce_mz_create.equals(payMethod)){
                //创建就诊卡
                returnXml = cardController.MzCardAdd(pamap);
            }else if(MethodConstants.proce_mz_charge.equals(payMethod)){
                //就诊卡充值
                returnXml = cardController.MzCardCz(pamap);
            }else if(MethodConstants.v_mz_charge.equals(payMethod)){
                //卡余额查询
                returnXml = cardController.MzCardCharge(pamap);
            }else if(MethodConstants.v_mz_bill.equals(payMethod)){
                //查询卡账单
                returnXml = cardController.MzCardBill(pamap);
            }else if(MethodConstants.v_mz_ks.equals(payMethod)){
                //查询医院预约科室
                returnXml = yuyueController.yuyueKs(pamap);
            }else if(MethodConstants.v_mz_doc.equals(payMethod)){
                //查询科室下的医生
                returnXml = yuyueController.yuyueDoc(pamap);
            }else if(MethodConstants.v_mz_yypb.equals(payMethod)){
                //查询医生排班信息
                returnXml = yuyueController.yuyuePb(pamap);
            }else if(MethodConstants.proce_mz_yue.equals(payMethod)){
                //生成预约信息
                returnXml = yuyueController.addYuyue(pamap);
            }else if(MethodConstants.v_mz_getyue.equals(payMethod)){
                //查询我的预约
                returnXml = yuyueController.yuyueList(pamap);
            }else if(MethodConstants.proce_mz_calyy.equals(payMethod)){
                //取消预约
                returnXml = yuyueController.deYuyue(pamap);
            }else if(MethodConstants.v_mz_ghks.equals(payMethod)){
                //查询医院挂号科室
                returnXml = guahaoController.guahaoKs(pamap);
            }else if(MethodConstants.v_mz_ghdoc.equals(payMethod)){
                //查询医院挂号科室下的医生
                returnXml = guahaoController.guahaoDoc(pamap);
            }else if(MethodConstants.v_mz_ghpb.equals(payMethod)){
                //查询医院挂号医生排班信息
                returnXml = guahaoController.guahaoPb(pamap);
            }else if(MethodConstants.proce_mz_gh.equals(payMethod)){
                //挂号
                returnXml = guahaoController.addGuahao(pamap);
            }else if(MethodConstants.v_mz_getgh.equals(payMethod)){
                //查询我的挂号信息
                returnXml = guahaoController.guahaoList(pamap);
            }else if(MethodConstants.proce_mz_calgh.equals(payMethod)){
                //取消挂号
                returnXml = guahaoController.deGuahao(pamap);
            }else if(MethodConstants.v_my_jy.equals(payMethod)){
                //查询我的检验信息
                returnXml = jiancyController.jyList(pamap);
            }else if(MethodConstants.v_my_jymx.equals(payMethod)){
                //查询检验信息明细
                returnXml = jiancyController.jymxList(pamap);
            }else if(MethodConstants.v_my_jc.equals(payMethod)){
                //查询检查信息
                returnXml = jiancyController.jcList(pamap);
            }else if(MethodConstants.v_my_jcmx.equals(payMethod)){
                //查询检查信息明细
                returnXml = jiancyController.jcmxInfo(pamap);
            }else if(MethodConstants.v_zy_cards.equals(payMethod)){
                //查询住院号
                returnXml = zycxController.zyCards(pamap);
            }else if(MethodConstants.v_zy_bill.equals(payMethod)){
                //查询住院缴费记录
                returnXml = zycxController.zyBill(pamap);
            }else if(MethodConstants.proce_zy_charge.equals(payMethod)){
                //住院押金充值
                returnXml = zycxController.zyCz(pamap);
            }else if(MethodConstants.v_zy_zd.equals(payMethod)){
                //查询住院账单
                returnXml = zycxController.zyZd(pamap);
            }else if(MethodConstants.v_zy_zdmx.equals(payMethod)){
                //查询住院账单明细
                returnXml = zycxController.zyZdmx(pamap);
            }else if(MethodConstants.v_hosp_tel.equals(payMethod)){
                //查询院内联系方式
                returnXml = hospController.docInfo(pamap);
            }else if(MethodConstants.v_wx_list.equals(payMethod)){
                //查询线上充值记录
                returnXml = refundController.getwxlist(pamap);
            }else if(MethodConstants.proce_wx_refund.equals(payMethod)){
                //进行退费
                returnXml = refundController.refund(pamap);
            }else if(MethodConstants.v_wx_refundlist.equals(payMethod)){
                //查询退费记录
                returnXml = refundController.refundList(pamap);
            }else if(MethodConstants.v_check_list.equals(payMethod)){
                //查询预约的项目
                returnXml = acidController.getItems(pamap);
            }else if(MethodConstants.proce_check_yy.equals(payMethod)){
                //预约核酸检测
                returnXml = acidController.addAcid(pamap);
            }else if(MethodConstants.proce_check_cal.equals(payMethod)){
                //取消预约
                returnXml = acidController.calAcid(pamap);
            }else if(MethodConstants.v_check_yy.equals(payMethod)){
                //查询预约记录
                returnXml = acidController.getYy(pamap);
            }else if(MethodConstants.proce_dzphz_dj.equals(payMethod)){
                //电子陪护证验证
                returnXml = dzphController.dzphCheck(pamap);
            }else {
                throw new ReException("Method 方法名传入错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("【HisWebServiceImpl-->Hiser】" + e.getMessage());
            returnXml = ResUtil.error(e.getMessage());
        }
        log.info("【当前时间是" + WebUtils.getDateTime() + ",返回的Xml是】:" + returnXml);
        log.info("--------------------------------------------------【调用结束，当前时间是：" + WebUtils.getDateTime() + "】--------------------------------------------------");
        return returnXml;
    }


}
