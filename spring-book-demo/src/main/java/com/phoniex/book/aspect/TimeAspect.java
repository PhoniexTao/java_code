package com.phoniex.book.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.security.PublicKey;

@Slf4j
@Aspect
@Component
public class TimeAspect {
    /**
     * 记录方法耗时
     */
    @Around("execution(* com.phoniex.book.controller.*.*(..))")
    public Object timeRecord(ProceedingJoinPoint pjp) throws Throwable {
        //1、记录开始时间
        long start = System.currentTimeMillis();
        //2、执行目标方法
        Object proceed = pjp.proceed();
        //3、记录方法执行结束时间
        long end = System.currentTimeMillis();
        //记录方法执行  耗时
        log.info(pjp.getSignature().toString() + "耗时:" + (end - start) + "ms");
        return proceed;
    }

    @Before("execution(* com.phoniex.book.controller.*.*(..))")
    public void doBefore() {
        log.info("doBefore...");
    }

    @After("execution(* com.phoniex.book.controller.*.*(..))")
    public void doAfter() {
        log.info("doAfter..");
    }

    @AfterReturning("execution(* com.phoniex.book.controller.*.*(..))")
    public void doAfterReturning(){
        log.info("doAfterReturning...");
    }

    @AfterThrowing("execution(* com.phoniex.book.controller.*.*(..))")
    public void doAfterThrowing(){
        log.info("doAfterThrowing...");
    }

}
