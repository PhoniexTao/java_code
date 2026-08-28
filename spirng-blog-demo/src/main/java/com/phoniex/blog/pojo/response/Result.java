package com.phoniex.blog.pojo.response;

import com.phoniex.blog.enums.ResultCodeEnum;
import lombok.Data;

@Data
public class Result {
    private ResultCodeEnum code;    //业务码
    private String errMsg;
    private Object data;


    public static Result success(Object data){
        Result result = new Result();
        result.setCode(ResultCodeEnum.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result fail(String Msg){
        Result result = new Result();
        result.setCode(ResultCodeEnum.FAIL);
        result.setErrMsg(Msg);
        return result;
    }
    public static Result fail(String Msg,Object data){
        Result result = new Result();
        result.setCode(ResultCodeEnum.FAIL);
        result.setErrMsg(Msg);
        result.setData(data);
        return result;
    }

}
