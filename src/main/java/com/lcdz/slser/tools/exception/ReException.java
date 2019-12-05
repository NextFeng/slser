package com.lcdz.slser.tools.exception;

import com.lcdz.slser.tools.enums.ResultEnum;

public class ReException extends RuntimeException {

    private Integer code;

    public ReException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public ReException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public ReException(String msg) {
        super(msg);
        this.code = 500;
    }

}
