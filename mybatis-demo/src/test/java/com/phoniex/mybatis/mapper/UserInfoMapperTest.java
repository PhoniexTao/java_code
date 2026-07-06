package com.phoniex.mybatis.mapper;

import com.phoniex.mybatis.model.UserInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void selectAll()  {
        System.out.println(userInfoMapper.selectAll());
    }

    @BeforeEach
    void setUp() {
        System.out.println("before...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("after...");
    }

    @Test
    void selectAllById() {
        System.out.println(userInfoMapper.selectAllById(2));
    }

    @Test
    void selectByNameAndPassword() {
        userInfoMapper.selectByNameAndPassword("zhangsan","zhangsan").stream().forEach(x-> System.out.println(x));
    }

    @Test
    void insertUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("username1");
        userInfo.setPassword("password2");
        userInfo.setAge(2);
        Integer result = userInfoMapper.insertUser(userInfo);
        //想要知道新插入元素的id，但是只能返回影响行数，那么通过对象来获取即可
        System.out.println("影响行数" + result + ", id:" + userInfo.getId());
    }

    @Test
    void insertUser2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("username3");
        userInfo.setPassword("password3");
        userInfo.setAge(4);
        Integer result = userInfoMapper.insertUser(userInfo);
        //想要知道新插入元素的id，但是只能返回影响行数，那么通过对象来获取即可
        System.out.println("影响行数" + result + ", id:" + userInfo.getId());
    }

    @Test
    void deleteUser() {
        userInfoMapper.deleteUser(9);
    }

    @Test
    void updateUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setDeleteFlag(1);
        userInfo.setPhone("1833423152");
        userInfoMapper.updateUser(userInfo);
    }

    @Test
    void selectUserInfoByOrder() {
        userInfoMapper.selectUserInfoByOrder("desc").stream().forEach(x-> System.out.println(x));
    }

    @Test
    void selectUserInfoByLike() {
        userInfoMapper.selectUserInfoByLike("asc").stream().forEach(x-> System.out.println(x));
    }
}