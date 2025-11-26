package org.ml.blog.exception;


import lombok.Getter;
import lombok.Setter;
import org.ml.blog.common.ResultCode;

public class BizException extends RuntimeException {
    @Getter
    @Setter
    int code;
    @Setter
    @Getter
    String msg;

    public BizException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BizException(ResultCode resultCode) {
        this(resultCode.getCode(), resultCode.getMsg());
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
