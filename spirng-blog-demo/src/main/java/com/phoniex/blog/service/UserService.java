package com.phoniex.blog.service;

import com.phoniex.blog.pojo.request.UserLoginRequest;
import com.phoniex.blog.pojo.response.UserInfoResponse;
import com.phoniex.blog.pojo.response.UserLoginResponse;

public interface UserService {
    UserLoginResponse checkPassword(UserLoginRequest userLoginRequest);

    UserInfoResponse getUserInfo(Integer userId);

    UserInfoResponse getAuthorInfo(Integer blogId);
}
