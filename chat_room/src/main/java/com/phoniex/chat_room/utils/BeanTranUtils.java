package com.phoniex.chat_room.utils;

import com.phoniex.chat_room.model.UserInfo;
import com.phoniex.chat_room.response.UserResponse;
import org.springframework.beans.BeanUtils;

public class BeanTranUtils{
    public static UserResponse tran(UserInfo userInfo){
        if(userInfo == null){
            return null;
        }
        UserResponse userLoginResponse = new UserResponse();
        BeanUtils.copyProperties(userInfo, userLoginResponse);
        return userLoginResponse;
    }
}
