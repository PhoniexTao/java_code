package com.phoniex.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@Order(1)
public class AspectDemo2 {
    @Before("com.phoniex.aop.aspect.AspectDemo1.pt()")
    public void doBefore() {
        log.info("AspectDemo2 doBefore....");
    }

    @After("com.phoniex.aop.aspect.AspectDemo1.pt()")
    public void doAfter(){
        log.info("AspectDemo2 doAfter....");
    }

}
