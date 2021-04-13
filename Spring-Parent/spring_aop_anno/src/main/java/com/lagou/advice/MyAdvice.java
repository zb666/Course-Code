package com.lagou.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

    @Pointcut("execution(* com.lagou.servlet.impl.AccountServiceImpl.*(..))")
    public void doPoint(){

    }

    //Around只要学一个就行了

    @Around("MyAdvice.doPoint()")
    public Object around(ProceedingJoinPoint joinPoint){
        Object proceed = null;
        try {
            System.out.println("前置通知");
            proceed = joinPoint.proceed();
            System.out.println("后置通知");
        } catch (Throwable throwable) {
            System.out.println("异常通知");
        }finally {
            System.out.println("最终通知执行了");
        }
        return proceed;
    }

}
