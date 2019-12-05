package com.lcdz.slser.tools.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    /**
     * 返回结果错误信息
     */
    SYSTEM_ERROR(500, "系统异常"),
    PARAM_EXIT(201, "缺少参数"),
    DATA_EXIT(101, "数据已存在"),
    DATA_NULL(102, "查询不到数据"),
    PAY_ORDERNULL(130, "订单生成失败"),
    PAY_ERROR(131, "His充值失败"),
    PAY_NOMONEY(132, "卡内余额不足"),
    OPENID_EXIT(150, "OPENID不存在"),;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
