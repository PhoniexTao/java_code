package com.phoniex.mybatis.mapper;

import com.phoniex.mybatis.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {
        //查询语句在java属性名和sql字段名不匹配时的处理策略：
    //1、sql语句加入as
//    @Select("SELECT id,username,`password`,age,gender,phone,delete_flag AS deleteFlag,create_time AS createTime,update_time AS updateTime FROM user_info")
//    List<UserInfo> selectAll();
    //2、使用Results注解来建立映射且录入id进行复用
//    @Results(id = "BaseMap", value = {
//            @Result(column = "delete_flag", property = "deleteFlag"),
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime")
//    })
//    @Select("select * from user_info")
//    List<UserInfo> selectAll();
    //3、配置：
    @Select("select * from user_info")
    List<UserInfo> selectAll();

//    @ResultMap(value = "BaseMap")
    @Select("select * from user_info where id = #{id}")
    UserInfo selectAllById(Integer id);

    @Select("SELECT * FROM `user_info` where username = #{userName} and `password` = #{password}")
    List<UserInfo> selectByNameAndPassword(@Param("userName") String username,@Param("password")String password);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into user_info (username, `password`,age) VALUES(#{username},#{password},#{age})")
    Integer insertUser(UserInfo userInfo);

    //对整个对象进行参数绑定，上方的sql占位符也要修改成对象.属性的形式
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into user_info (username, `password`,age) VALUES (#{userInfo.username},#{userInfo.password},#{userInfo.age})")
    Integer insertUser2(@Param("userInfo") UserInfo userInfo);

    @Delete("delete from user_info where id = #{id}")
    Integer deleteUser(Integer id);

    @Update("update user_info set delete_flag = #{deleteFlag},phone = #{phone} where id = #{id}")
    Integer updateUser(UserInfo userInfo);

}
