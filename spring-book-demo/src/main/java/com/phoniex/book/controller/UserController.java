package com.phoniex.book.controller;

import com.phoniex.book.constant.Constants;
import com.phoniex.book.model.UserInfo;
import com.phoniex.book.service.UserInfoService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/login")
    public Boolean login(String name, String password, HttpSession session) {
        //1、参数的校验
        //2、检验账号密码是否正确
        //3、设置session
        //4、返回结果

        if (!StringUtils.hasLength(name) || !StringUtils.hasLength(password)) {
            return false;
        }
        //根据用户名，获取用户信息
        UserInfo userInfo = userInfoService.queryUserInfoByName(name);
        if (userInfo == null) {
            return false;
        }
        if (password.equals(userInfo.getPassword())) {
            userInfo.setPassword("");
            session.setAttribute(Constants.SESSION_USER_KEY, userInfo);
            return true;
        }
        //未加入数据库，这里写死
//        if("admin".equals(name) && "123456".equals(password)){
//            session.setAttribute("userName",name);
//            return true;
//        }

        return false;
    }
}
