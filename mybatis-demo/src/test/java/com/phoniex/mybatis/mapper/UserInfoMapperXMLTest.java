package com.phoniex.mybatis.mapper;

import com.phoniex.mybatis.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperXMLTest {

    @Autowired
    private UserInfoMapperXML userInfoMapperXML;

    @Test
    void selectAll() {
        userInfoMapperXML.selectAll().stream().forEach(x-> System.out.println(x));
    }

    @Test
    void insertUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("username4");
        userInfo.setPassword("password4");
        userInfo.setAge(5);
        userInfoMapperXML.insertUser(userInfo);

    }

    @Test
    void insertUser2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("username5");
        userInfo.setPassword("password5");
        userInfo.setAge(6);
        Integer result = userInfoMapperXML.insertUser(userInfo);
        System.out.println("影响行数：" + result + ", 自增id:"+ userInfo.getId());
    }

    @Test
    void updateUser() {
        userInfoMapperXML.updateUser("updatePasswors5",  8,12);
    }

    @Test
    void deleteUser() {
        userInfoMapperXML.deleteUser(12);
    }

    @Test
    void selectByCondition() {
        UserInfo userInfo = new UserInfo();
        userInfo.setPhone("1001");
        userInfo.setDeleteFlag(0);
        userInfoMapperXML.selectByCondition(userInfo).stream().forEach(x-> System.out.println(x));
    }

    @Test
    void updateByConfition() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(23);
        userInfo.setPassword("password5");
        userInfo.setAge(20);
        userInfo.setGender(2);
        userInfoMapperXML.updateByConfition(userInfo);
    }

    @Test
    void batchDelete() {
        List<Integer> ids = List.of(20,21,22,23);
        userInfoMapperXML.batchDelete(ids);
    }
}