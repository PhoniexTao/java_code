package com.phoniex.ioc.resp;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public void print(){
        System.out.println("do repository");
    }
}
