package com.phoniex.mybatis.mapper;

import com.phoniex.mybatis.model.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfoMapperXML {

    List<UserInfo> selectAll();

    List<UserInfo> selectAll2();
    Integer insertUser(UserInfo userInfo);
    Integer insertUser2(@Param("userInfo") UserInfo userInfo);

    Integer updateUser(String password,Integer age, Integer id);

    Integer deleteUser(Integer id);
}
