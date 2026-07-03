package com.phoniex.mybatis.service;

import com.phoniex.mybatis.mapper.UserInfoMapper;
import com.phoniex.mybatis.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    public List<UserInfo> getAllUser() {
        return userInfoMapper.selectAll();
    }
    public UserInfo getUserInfoById(Integer id){
        return userInfoMapper.selectAllById(id);
    }
}
