package com.phoniex.blog.controller;

import com.phoniex.blog.pojo.request.UserLoginRequest;
import com.phoniex.blog.pojo.response.UserInfoResponse;
import com.phoniex.blog.pojo.response.UserLoginResponse;
import com.phoniex.blog.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.PushBuilder;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Resource(name = "userServiceImpl")
    private UserService userService;

    @RequestMapping("/login")
    public UserLoginResponse login(@RequestBody @Validated UserLoginRequest userLoginRequest) {
        log.info("用户登录，用户名:" + userLoginRequest.getUserName());
        return userService.checkPassword(userLoginRequest);
    }

    @RequestMapping("/getUserInfo")
    public UserInfoResponse getUserInfo(@NotNull(message = "userId不能为空") Integer userId) {
        log.info("获取用户信息：" + userId);
        return userService.getUserInfo(userId);
    }

    @RequestMapping("/getAuthorInfo")
    public UserInfoResponse getAuthorInfo(@NotNull(message = "blogId不能为空") Integer blogId){
        log.info("获取博客作者的信息：" + blogId);
        return userService.getAuthorInfo(blogId);
    }
}
