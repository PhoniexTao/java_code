package com.phoniex.blog.common.interceptor;

import com.phoniex.blog.common.constant.Constants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //约定前端把用户的token放在header中，所以要取出来
        String userToken = request.getHeader(Constants.USER_TOKEN_HEADER_KEY);
        log.info("header中获取token:" + userToken);
        if(userToken == null){
            //用户没有传令牌进行拦截
            response.setStatus(401);
            return false;
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
