package com.phoniex.book.config;

import com.phoniex.book.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.Null;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
@ResponseBody
    public class ExceptionAdvice {
    @ExceptionHandler
    public Result handler1(Exception e){
        log.error("发生异常,e: ",e);
        return Result.fail("内部错误，请联系管理员");
    }

//    @ExceptionHandler
    @ExceptionHandler(NullPointerException.class)
    public Result handler2(Exception e){
        log.error("发生异常，e:", e);
        return Result.fail("发生空指针异常，请联系管理员");
    }
    @ExceptionHandler
    public Result handler3(IndexOutOfBoundsException e){
        log.error("发生异常,e:", e);
        return Result.fail("数组越界异常，请联系管理员");
    }
}
