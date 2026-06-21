package com.phoniex.ioc.service;

import com.phoniex.ioc.model.Student;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //指定名注解
//    @Qualifier("s3")
//    @Autowired
//    private Student s1;

    //指定名注解
    @Resource(name = "s3")
    private Student s1;
    public void print(){
        System.out.println("service do");
        System.out.println(s1);
    }
}
