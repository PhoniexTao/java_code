package com.phoniex.spring.demo;

import ch.qos.logback.core.util.StringUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/login")
    public Boolean login(String userName, String password, HttpSession session){
        //参数的校验
//        if(userName == null || userName == "" || password == null || password == ""){
//
//        }
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)){
            return false;
        }
        //校验用户名密码是否正确
        //还未学习数据库相关的操作，暂且把账号密码写死
        if("admin".equals(userName) && "123456".equals(password)){
            //密码正确
            session.setAttribute("userName",userName);
            return true;
        }
        return false;
    }

    @RequestMapping("/getLoginUser")
    public  String getLoginUser(HttpSession session){
        String userName = (String) session.getAttribute("userName");

        return userName;
    }


}
