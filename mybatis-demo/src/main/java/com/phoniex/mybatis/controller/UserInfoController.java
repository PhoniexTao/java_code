package com.phoniex.mybatis.controller;

import com.phoniex.mybatis.model.UserInfo;
import com.phoniex.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getAllUser")
    public List<UserInfo> getAllUser() {
        return userService.getAllUser();
    }

    @RequestMapping("getUserInfoById")
    public UserInfo getUserInfoById(Integer id){
        return userService.getUserInfoById(id);
    }
}
