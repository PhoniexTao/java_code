package com.phoniex.trans.controller;


import com.phoniex.trans.Sevice.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user2")
@Slf4j
public class UserController2 {
    @Autowired
    private UserService userService;

    @Transactional
    @RequestMapping("/registry")
    public String registry(String name, String password){
        //用户注册
        try {
            Integer result = userService.registryUser(name, password);
            log.info("用户注册成功,影响行数：" + result);
        }catch (Exception e){
            log.error("程序发生异常");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return "注册成功";
    }
}
