package org.ml.blog.common;


import org.ml.blog.exception.BizException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception e) {
        return Result.error(1001, "系统异常，请联系管理员！！！");
    }

    @ExceptionHandler(BizException.class)
    public Result<?> handleBizException(BizException e) {
        return Result.error(e.getCode(), e.getMessage());
    }
}
