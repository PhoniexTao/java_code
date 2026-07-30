package com.phoniex.mybatis.plus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.phoniex.mybatis.plus.model.UserInfo;
import net.bytebuddy.asm.Advice;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Update;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    void selectByCondition(){
        // select id, username, password, age, delete_flag from user_info where age = 15 and username like "%min%"
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","username","password")
            .eq("age",16)
            .like("username","zhangsan");

        List<UserInfo> userInfos = userInfoMapper.selectList(queryWrapper);
        userInfos.forEach(System.out::println);
    }
    @Test
    void selectByCondition2(){
        // select id, username, password, age, delete_flag from user_info where age = 15 and username like "%min%"
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select(UserInfo::getId,UserInfo::getUsername,UserInfo::getPassword,UserInfo::getAge,
                UserInfo::getDeleteFlag)
            .eq(UserInfo::getAge,15)
            .like(UserInfo::getUsername,"min");

        List<UserInfo> userInfos = userInfoMapper.selectList(queryWrapper);
        userInfos.forEach(System.out::println);
    }

    @Test
    void updateByCondition(){
        UserInfo userInfo = new UserInfo();
        userInfo.setDeleteFlag(1);

        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lt("age",20);

        userInfoMapper.update(userInfo, updateWrapper);

    }

    //省去创建类对象
    @Test
    void updateByCondition2(){

        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("delete_flag",0).lt("age",20);

        userInfoMapper.update(updateWrapper);

    }

    //对多条数据进行修改
    @Test
    void updateByCondition3(){
        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("delete_flag",0).set("age",5)
                     .in("id",List.of(1,2,3));
        userInfoMapper.update(updateWrapper);
    }
    @Test
    void updateByCondition4(){
        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.setSql("age = age + 10");
        userInfoMapper.update(updateWrapper);

    }
    @Test
    void updateByCondition5(){

        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().set(UserInfo::getDeleteFlag,0).lt(UserInfo::getAge,20);
        userInfoMapper.update(updateWrapper);

    }
    @Test
    void deleteByCondition(){
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age",18);
        userInfoMapper.delete(queryWrapper);
    }

    @Test
    void selectById2(){
        UserInfo userInfo = userInfoMapper.selectById2(2);
        System.out.println(userInfo);
    }

    @Test
    void selectById3() {
        UserInfo userInfo = userInfoMapper.selectById3(2);
        System.out.println(userInfo);
    }

    @Test
    void selectUserInfoByCondition() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("age",20);
        userInfoMapper.selectUserInfoByCondition(queryWrapper).forEach(System.out::println);
    }

    @Test
    void updateById2() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id",List.of(1,2,3));
        userInfoMapper.updateById2(10,queryWrapper);
    }


}