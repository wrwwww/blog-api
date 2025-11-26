package org.ml.blog.common;

import lombok.Getter;

@Getter
public enum ResultCode {
    SYS_ERROR(1001, "系统异常，请联系管理员!"),
    PARAM_LOST(2001, "参数错误!");

    private final int code;
    private final String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
