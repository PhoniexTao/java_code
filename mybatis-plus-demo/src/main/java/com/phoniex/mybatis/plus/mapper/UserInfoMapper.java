package com.phoniex.mybatis.plus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.phoniex.mybatis.plus.model.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.yaml.snakeyaml.scanner.Constant;

import java.util.List;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    @Select("select * from user_info where id = #{id}")
    UserInfo selectById2(Integer id);
    UserInfo selectById3(Integer id);

    @Select("select id, username, password, age from username ${ew.customSqlSegment}")
    List<UserInfo> selectUserInfoByCondition(@Param(Constants.WRAPPER) Wrapper<UserInfo> queryWrapper);

    @Update("update userInfo set age = age + #{addAge} ${ew.customSqlSegment}")
    Integer updateById2(Integer addAge,@Param(Constants.WRAPPER) Wrapper<UserInfo> queryWrapper);
}
