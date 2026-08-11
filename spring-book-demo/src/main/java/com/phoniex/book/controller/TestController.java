package com.phoniex.book.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {
    @RequestMapping("/t1")
    public Integer t1() {
        int a = 10 / 0;
        return 1;
    }

    @RequestMapping("/t2")
    public Boolean t2() {
        int[] aa = {1, 2, 3};
        System.out.println(aa[4]);
        return true;
    }

    @RequestMapping("t3")
    public String t3(){
        String a = null;
        System.out.println(a.length());
        return "t3";
    }
}
