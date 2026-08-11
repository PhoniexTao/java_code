package com.phoniex.book.model;

import com.phoniex.book.enums.ResultCodeEnum;
import lombok.Data;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;

/**
 * code = -1 用户未登录
 * code = -2 后端出错
 * code = 200 后端正常响应
 */
@Data
public class Result<T> {
    private ResultCodeEnum code;
    private String errMsg;
    private Object data;

    public static <T> Result success(T data){
        Result result = new Result();
        result.setCode(ResultCodeEnum.SUCCESS);
        result.setErrMsg("");
        result.setData(data);
        return result;
    }
    public static <T> Result fail(String errMsg){
        Result result = new Result();
        result.setCode(ResultCodeEnum.FAIL);
        result.setErrMsg(errMsg);
        result.setData(null);
        return result;
    }
    public static <T> Result unlogin(   ){
        Result result = new Result();
        result.setCode(ResultCodeEnum.UNLOGIN);
        result.setErrMsg("用户未登录");
        result.setData(null);
        return result;
    }
}
