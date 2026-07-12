package com.phoniex.book.mapper;

import com.phoniex.book.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfomapper {
    @Select("SELECT * FROM user_info WHERE user_name= #{name}")
    UserInfo queryUserInfoByName(String name);

}
