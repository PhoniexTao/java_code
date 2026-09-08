package com.phoniex.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.phoniex.blog.common.exception.BlogException;
import com.phoniex.blog.common.util.BeanTranUtils;
import com.phoniex.blog.common.util.JwtUtils;
import com.phoniex.blog.mapper.BlogInfoMapper;
import com.phoniex.blog.mapper.UserInfoMapper;
import com.phoniex.blog.pojo.dataobject.BlogInfo;
import com.phoniex.blog.pojo.dataobject.UserInfo;
import com.phoniex.blog.pojo.request.UserLoginRequest;
import com.phoniex.blog.pojo.response.UserInfoResponse;
import com.phoniex.blog.pojo.response.UserLoginResponse;
import com.phoniex.blog.service.BlogService;
import com.phoniex.blog.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private BlogService blogService;

    @Override
    public UserLoginResponse checkPassword(UserLoginRequest userLoginRequest) {
        //查询数据库
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq(UserInfo::getUserName,userLoginRequest.getUserName())
            .eq(UserInfo::getDeleteFlag,0);
        //TODO 添加trycatch(返回结果不止一个时)
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
        if (userInfo==null){
            //用户不存在
            throw new BlogException("用户不存在");
        }
        //判断密码是否正确
        if(!userLoginRequest.getPassword().equals(userInfo.getPassword())){
            throw  new BlogException("用户密码错误");
        }
        //密码正确
        Map<String ,Object> map = new HashMap<>();
        map.put("id", userInfo.getId());
        map.put("name",userInfo.getUserName());
        String token = JwtUtils.getToken(map);
        return new UserLoginResponse(userInfo.getId(),token);
    }

    @Override
    public UserInfoResponse getUserInfo(Integer userId) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserInfo::getId, userId)
            .eq(UserInfo::getDeleteFlag, 0);
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
        return BeanTranUtils.trans(userInfo);
    }

    @Override
    public UserInfoResponse getAuthorInfo(Integer blogId) {
        //1、根据博客ID获取作者ID
        BlogInfo blogInfo = blogService.getBlogInfo(blogId);
        if (blogInfo == null || blogInfo.getUserId() <= 0) {
            throw new BlogException("博客不存在");
        }
        //2、根据作者Id，获取作者信息
        return getUserInfo(blogInfo.getUserId());
    }
}
