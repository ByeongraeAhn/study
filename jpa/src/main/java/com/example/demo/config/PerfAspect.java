package com.example.demo.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class PerfAspect {

    //패키지
    @Around("execution(* com.example.demo.web.*.*(..))")
    public Object logPerfByExecution(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        System.out.println(System.currentTimeMillis() - begin);
        System.out.println("From Execution");
        return retVal;
    }

    //어노테이션
    // @Around("@annotation(PerfLogging)")
    // public Object logPerfByAnnotation(ProceedingJoinPoint pjp) throws Throwable {
    //     long begin = System.currentTimeMillis();
    //     Object retVal = pjp.proceed();
    //     System.out.println(System.currentTimeMillis() - begin);
    //     System.out.println("From Annotation");
    //     return retVal;
    // }

    //bean 이름
    // @Around("bean(helloController)")
    // public Object logPerfByBean(ProceedingJoinPoint pjp) throws Throwable {
    //     long begin = System.currentTimeMillis();
    //     Object retVal = pjp.proceed();
    //     System.out.println(System.currentTimeMillis() - begin);
    //     System.out.println("From Beanname");
    //     return retVal;
    // }


}