package com.phoniex.chat_room.controller;

import com.phoniex.chat_room.model.UserInfo;
import com.phoniex.chat_room.request.UserLoginRequest;
import com.phoniex.chat_room.response.UserResponse;
import com.phoniex.chat_room.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("user")
@RestController
public class UserController {
    @Resource(name = "userServiceImpl")
    private UserService userService;

    @PostMapping("/login")
    public UserResponse login(@ModelAttribute @Validated UserLoginRequest userLoginRequest, HttpServletRequest req) {
        log.info("用户登录：username: " + userLoginRequest.getUserName());
        return userService.login(userLoginRequest, req);
    }

    @PostMapping("/register")
    public UserInfo register(@ModelAttribute @Validated UserLoginRequest userLoginRequest){
        log.info("用户注册: username :" + userLoginRequest.getUserName());
        return userService.register(userLoginRequest);
    }
}
