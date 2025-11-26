package org.ml.blog.common;

public enum ResultCode {
    SYS_ERROR(1001, "系统异常，请联系管理员！");

    private final int code;
    private final String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
