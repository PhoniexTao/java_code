package com.phoniex.chat_room.service;

import com.phoniex.chat_room.mapper.UserMapper;
import com.phoniex.chat_room.model.UserInfo;
import com.phoniex.chat_room.request.UserLoginRequest;
import com.phoniex.chat_room.response.UserResponse;
import com.phoniex.chat_room.utils.BeanTranUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserResponse login(UserLoginRequest userLoginRequest, HttpServletRequest req ) {
        UserInfo userInfo = new UserInfo();
        userInfo = userMapper.selectByUserName(userLoginRequest.getUserName());
        if(userInfo == null || !userInfo.getPassword().equals(userLoginRequest.getPassword())){
            log.error("用户登录失败,用户名或密码错误");

            return new UserResponse();
        }
        //如果密码匹配，创建会话
        HttpSession session = req.getSession(true);
        session.setAttribute("userId",userInfo.getUserId());
        UserResponse userLoginResponse = new UserResponse();
        userLoginResponse = BeanTranUtils.tran(userInfo);
        return userLoginResponse;
    }

    @Override
    public UserInfo register(UserLoginRequest userLoginRequest) {
        UserInfo userInfo = new UserInfo();
        try {
            userInfo.setUserName(userLoginRequest.getUserName());
            userInfo.setPassword(userLoginRequest.getPassword());
            int ret = userMapper.userInfoInsert(userInfo);
            log.info("注册返回：ret = " + ret);
        } catch (DuplicateKeyException e) {
            //如果insert方法抛出上述异常说明用户名重复
            userInfo = new UserInfo();
        }
        return userInfo;
    }
}
