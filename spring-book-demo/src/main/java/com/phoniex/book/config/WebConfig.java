package com.phoniex.book.config;

import com.phoniex.book.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {   // 给拦截器对象进行具体操作的添加
        registry.addInterceptor(loginInterceptor)
            .addPathPatterns("/book/**");     //添加拦截路径
//            .excludePathPatterns("/");     // 排除拦截路径

    }
}
