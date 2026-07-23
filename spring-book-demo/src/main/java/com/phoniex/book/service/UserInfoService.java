package com.phoniex.book.service;

import com.phoniex.book.mapper.UserInfomapper;
import com.phoniex.book.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    UserInfomapper userInfomapper;

    public UserInfo queryUserInfoByName(String name) {
        return userInfomapper.queryUserInfoByName(name);
    }
}
