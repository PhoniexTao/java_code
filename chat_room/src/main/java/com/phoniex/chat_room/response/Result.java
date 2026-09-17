package com.phoniex.chat_room.response;

import com.phoniex.chat_room.enums.ResultCodeEnum;
import lombok.Data;

@Data
public class Result {
    private ResultCodeEnum code;
    private String errMsg;
    private Object data;

    public static Result success(Object data){
        Result result = new Result();
        result.setCode(ResultCodeEnum.SUCCESS);
        result.setData(data);
        return result;
    }
    public static Result fail(String errMsg){
        Result result = new Result();
        result.setCode(ResultCodeEnum.FAIL);
        result.setErrMsg(errMsg);
        return result;
    }

}
