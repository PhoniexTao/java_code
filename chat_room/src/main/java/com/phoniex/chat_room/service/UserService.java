package com.phoniex.chat_room.service;

import com.phoniex.chat_room.model.UserInfo;
import com.phoniex.chat_room.request.UserLoginRequest;
import com.phoniex.chat_room.response.UserResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {

    UserResponse login(UserLoginRequest userLoginRequest, HttpServletRequest req);

    UserInfo register(UserLoginRequest userLoginRequest);
}
