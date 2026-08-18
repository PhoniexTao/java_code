package com.phoniex.trans.controller;

import com.phoniex.trans.Sevice.UserService;
import org.springframework.transaction.TransactionDefinition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    //代码式事物
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    private TransactionDefinition definition;

    @RequestMapping("/registry")
    public String registry(String name, String password) {
        //1、开启事务
        //2、数据操作
        //3、事务提交/回滚

        //开启事务：
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(definition);
        //⽤⼾注册
        userService.registryUser(name, password);
        log.info("用户注册成功");
        //事务提交：
//        dataSourceTransactionManager.commit(transaction);
        //事务回滚：
        dataSourceTransactionManager.rollback(transaction);
        return "注册成功";
    }
}
