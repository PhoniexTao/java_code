package com.phoniex.book.interceptor;

import com.phoniex.book.constant.Constants;
import com.phoniex.book.model.Result;
import com.phoniex.book.model.UserInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle 目标方法执行前...");
        //判断是否登录
        HttpSession session = request.getSession(false);
        if(!checkUser(session)){
            //如果你要使用response返回中文需要设置编码
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(401);
            String msg = "用户未登录";
            response.getOutputStream().write(msg.getBytes("UTF-8"));
            return false;
        }

        //true 放行 ， false 拦截
        return true;
    }
    public boolean checkUser(HttpSession session){
        if (session == null || session.getAttribute(Constants.SESSION_USER_KEY) == null) {
            log.warn("用户未登录");
            //用户未登录
            return false;
        }
        UserInfo userInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER_KEY);
        if (userInfo == null || userInfo.getId() <= 0) {
            log.warn("用户未登录");
            //用户未登录
            return false;
        }
        log.info("用户已登录");
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        log.info("postHandle.....");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        log.info("afterCompletion....");
    }
}
