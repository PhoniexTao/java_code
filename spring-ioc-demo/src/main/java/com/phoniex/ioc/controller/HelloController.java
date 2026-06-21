package com.phoniex.ioc.controller;

import com.phoniex.ioc.config.UserConfig;
import com.phoniex.ioc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

    //属性注入：
//    @Autowired
//    private UserService userService;

    //构造方法注入：
    final String less;
    private UserService us;

    public HelloController(String less) {
        this.less = less;
    }
    //指定默认构造函数
    @Autowired
    public HelloController(UserService us,String less){
        this.us = us;
        this.less = less;
    }

    //setter 方法注入
    @Autowired
    private UserConfig userConfig;
    public void setUserConfig(UserConfig userConfig){
        this.userConfig = userConfig;
    }
    public void print(){
        System.out.println("do Controller");
        System.out.println(us);
        us.print();
    }
}
