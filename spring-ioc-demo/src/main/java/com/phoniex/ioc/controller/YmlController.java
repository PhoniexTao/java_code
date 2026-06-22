package com.phoniex.ioc.controller;

import com.phoniex.ioc.model.Dbtypes;
import com.phoniex.ioc.model.Person;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class YmlController {
    @Value("${my.key1}")
    private String mykey1;

    @Value("${my.key2}")
    private Integer mykey2;

    @Autowired
    private Person person;
    @Autowired
    private Dbtypes dbtypes;

    @PostConstruct
    public void init(){
        System.out.println("mykey1" + mykey1);
        System.out.println("mykey2:" + mykey2);
        System.out.println("person:" + person);
        System.out.println("dbtypes:" + dbtypes);
    }
}
