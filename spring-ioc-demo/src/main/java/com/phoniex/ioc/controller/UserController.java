package com.phoniex.ioc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
public class UserController {
    @RequestMapping("hello")
    public String hello() {
        return "测试Controller和Service 区别";
    }
}
