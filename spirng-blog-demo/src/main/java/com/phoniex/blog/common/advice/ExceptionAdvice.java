package com.phoniex.blog.common.advice;


import com.phoniex.blog.common.exception.BlogException;
import com.phoniex.blog.pojo.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionAdvice {
    @ExceptionHandler
    public Result exceptionHandler(Exception e){
        log.error("发生异常,e：", e);
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler
    public Result exceptionHandler(BlogException e){
        log.error("发生异常,e ：", e);
        return Result.fail(e.getMessage());
    }
    @ExceptionHandler
    public Result exceptionHandler(HandlerMethodValidationException e){
        log.error("发生异常,e :",e);
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler
    public Result exceptionHandler(MethodArgumentNotValidException e) {
        //该异常的错误信息不太好拿：
        //TODO 空指针处理
        // 记录完整的错误列表
        log.error("参数校验失败，详情：{}", e.getBindingResult().getAllErrors());

        // 优先取字段错误，没有则取全局错误
        String msg = "";
        if (e.getFieldError() != null) {
            msg = e.getFieldError().getDefaultMessage();
        } else if (e.getBindingResult().getGlobalError() != null) {
            msg = e.getBindingResult().getGlobalError().getDefaultMessage();
        } else {
            msg = "参数校验失败";
        }
        return Result.fail(msg);
    }

}
