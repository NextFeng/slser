package com.lcdz.slser.tools.result;

import lombok.Data;


@Data
public class ReView<T> {
    private Integer code;
    private String msg;
    private T data;
}
