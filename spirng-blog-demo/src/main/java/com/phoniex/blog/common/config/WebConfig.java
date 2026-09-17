package com.phoniex.blog.common.config;

import com.phoniex.blog.common.interceptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginInterceptor)
            .addPathPatterns("/blog/**","/user/**")
<<<<<<< HEAD
            .excludePathPatterns(
                "/user/login",
                "/blog/getlist",
                "/blog/getBlogDetail",
                "/user/getAuthorInfo"
            );
=======
            .excludePathPatterns("/user/login");

>>>>>>> github/master
    }
}
