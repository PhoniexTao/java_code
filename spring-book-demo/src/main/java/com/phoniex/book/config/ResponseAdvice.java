package com.phoniex.book.config;

import com.phoniex.book.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import tools.jackson.databind.ObjectMapper;

import java.lang.runtime.ObjectMethods;

@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    //判断是否支持
    public boolean supports(MethodParameter returnType, Class converterType) {

        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        //在Spring管理返回值时，如果检测到返回值为String类型除了包装成Result类型之外还会调用一个方法的对应实现，
        // String类型对应的实现必须要是String，所以之前包装成Result就会导致代码出错。
        //除此之外，Spring管理对应方法的注解应该变成： @RequestMapping(value = "/addBook",produces = "application/json")
        //否则前端无法识别非json的返回信息
        if(body instanceof String){
            //所以我们需要对其进行处理：
            return objectMapper.writeValueAsString(Result.success(body));
        }
        //有的方法返回值本身就已经是Result就无需再次封装：
        if(body instanceof Result){
            return body;
        }
        return Result.success(body);
    }

}
