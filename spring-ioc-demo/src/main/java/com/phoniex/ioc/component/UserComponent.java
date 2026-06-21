package com.phoniex.ioc.component;

import org.springframework.stereotype.Component;

@Component
public class UserComponent {
    public void print(){
        System.out.println("do component");
    }
}
