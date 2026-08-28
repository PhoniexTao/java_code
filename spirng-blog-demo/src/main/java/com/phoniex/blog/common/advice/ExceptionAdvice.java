package com.phoniex.blog.common.advice;


import com.phoniex.blog.common.exception.BlogException;
import com.phoniex.blog.pojo.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionAdvice {
    @ExceptionHandler
    public Result exceptionHandler(Exception e){
        log.error("发生异常：", e);
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler
    public Result exceptionHandler(BlogException e){
        log.error("发生异常：", e);
        return Result.fail(e.getMessage());
    }
}
