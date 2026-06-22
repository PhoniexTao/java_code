package com.phoniex.ioc.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/prop")
@ResponseBody
@Controller
public class PropertiesController {

    @Value("${my.key}")
    private String mykey;

    public String readvalue(){
       return "读取配置文件my.key:" + mykey;
    }
    @PostConstruct
    public  void init(){
        System.out.println("mykey"+mykey);
    }
}
