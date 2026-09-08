package com.phoniex.blog.common.interceptor;

import com.phoniex.blog.common.constant.Constants;
import com.phoniex.blog.common.context.UserContext;
import com.phoniex.blog.common.util.JwtUtils;
import io.jsonwebtoken.Claims;
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
        Claims claims = JwtUtils.parseToken(userToken);
        if(claims == null){
            //用户没有传令牌进行拦截
            response.setStatus(401);
            return false;
        }
        Object idObj = claims.get("id");
        if (idObj == null){
            response.setStatus(401);
            return false;
        }
        UserContext.setUserId(((Number) idObj).intValue());
        return true;
//        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) {
        UserContext.clear();              // 关键：线程池会复用线程，必须清理
    }
}
