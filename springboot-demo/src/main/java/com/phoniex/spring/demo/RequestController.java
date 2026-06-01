package com.phoniex.spring.demo;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController {
    @RequestMapping("r1")
    public String r1(String keyword) {
        return "接收参数: " + keyword;
    }

    @RequestMapping("r2")
    public String r2(String userName,String password){
        return "接收参数: userName: "+ userName + " pas sword: " + password;
    }
    @RequestMapping("/r5")
    public String r5(UserInfo userInfo){
        return  "接收参数 : userInfo = " + userInfo.toString();
    }

    //接收前端参数名为为q的代码，如果接收不到则报错
    @RequestMapping("/r6")
    public String r6(@RequestParam("q") String keyword){
        return "接收参数: keyword = " + keyword;
    }

    ////接收前端参数名为为q的代码，如果接收不到返回null不报错
    @RequestMapping("/r7")
    public String r7(@RequestParam(value = "q",required = false) String keyword){
        return "接收参数 ： keyword= " + keyword;
    }

    //传递数组
    @RequestMapping("/r8")
    public String r8(String[] arr){
        return "接收参数: arr = "+ arr;
    }

    //传递集合 ： 要进行参数绑定
    @RequestMapping("/r9")
    public String r9(@RequestParam List<Integer> list){
        return  "接收参数 ： list = " + list;
    }
}
