package com.phoniex.chat_room.mapper;

import com.phoniex.chat_room.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    //把用户插入到数据库中->注册
    int userInfoInsert(UserInfo user);
    //根据用户id查询用户信息：
    UserInfo selectByUserId(Integer userId);
    //根据用户名查询用户信息：
    UserInfo selectByUserName(String userName);
}

