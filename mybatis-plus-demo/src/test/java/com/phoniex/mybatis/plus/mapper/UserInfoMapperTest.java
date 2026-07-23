package com.phoniex.mybatis.plus.mapper;

import com.phoniex.mybatis.plus.model.UserInfo;
import org.apache.ibatis.annotations.Update;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void insert(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("admin");
        userInfo.setPassword("123456");
        userInfo.setPhone("454212421");
        userInfo.setAge(21);
        userInfoMapper.insert(userInfo);
    }

    @Test
    void delete(){
        userInfoMapper.deleteById(1);

    }
    @Test
    void update(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(4);
        userInfo.setUsername("admin444");
        userInfo.setPassword("123456");
        userInfo.setAge(21);
        userInfoMapper.updateById(userInfo);
    }
    @Test
    void select(){
        UserInfo userInfo = userInfoMapper.selectById(4);
        System.out.println(userInfo);
    }
}