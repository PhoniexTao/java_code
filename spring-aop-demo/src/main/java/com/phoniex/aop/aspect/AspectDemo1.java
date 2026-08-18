package com.phoniex.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Slf4j
@Aspect
@Component
public class AspectDemo1 {
    /**
     * 记录方法耗时
     */
    @Pointcut("execution(* com.phoniex.aop.controller.*.*(..))")
    public void pt(){};
    @Around("pt()")
    public Object timeRecord(ProceedingJoinPoint pjp){
        //1、记录开始时间
        long start = System.currentTimeMillis();
        //2、执行目标方法
        Object proceed = null;
        try {
            proceed = pjp.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        //3、记录方法执行结束时间
        long end = System.currentTimeMillis();
        //记录方法执行  耗时
        log.info(pjp.getSignature().toString() + "耗时:" + (end - start) + "ms");
        return proceed;
    }

    @Before("pt()")
    public void doBefore() {
        log.info("doBefore...");
    }

    @After("pt()")
    public void doAfter() {
        log.info("doAfter..");
    }

    @AfterReturning("pt()")
    public void doAfterReturning(){
        log.info("doAfterReturning...");
    }

    @AfterThrowing("pt()")
    public void doAfterThrowing(){
        log.info("doAfterThrowing...");
    }

}
