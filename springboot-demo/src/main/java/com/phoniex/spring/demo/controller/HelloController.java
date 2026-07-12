package com.phoniex.spring.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("hei")
    public String m1(){
        //com.phoniex.spring.demo.controller.UserController#m1()
        return "hello, Spring boot";
    }
}

