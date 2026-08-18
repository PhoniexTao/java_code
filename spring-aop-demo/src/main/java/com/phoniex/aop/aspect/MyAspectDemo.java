package com.phoniex.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MyAspectDemo {
    @Around("@annotation(com.bit.aop.aspect.MyAspect)")
    public Object recordTime(ProceedingJoinPoint pjp) {
        log.info("目标方法执行前...");
        //执行目标方法
        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            log.error("do Around throwing....");
        }
        //记录方法执行结束时间
        log.info("目标方法执行后....");

        return result;
    }
}
