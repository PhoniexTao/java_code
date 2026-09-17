package com.phoniex.chat_room.advice;

import com.phoniex.chat_room.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@ControllerAdvice
@Slf4j
public class ExceptionAdvice{
    @ExceptionHandler
    public Result ExceptionHandler(Exception e){
        log.error(e.getMessage());
        return Result.fail(e.getMessage());
    }

}
