package com.example.spring.xxaop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @date:2020/1/8 21:43
 **/
@Slf4j
@Aspect
@Component
public class XxAdvice {

    // Caused by: java.lang.IllegalArgumentException: ProceedingJoinPoint is only supported for around advice
    // 如果这里使用@Before会报错的！！！
    @Around(value = "(execution(* com.example.spring.eventandjpa..*.*(..)))")
    public Object service(ProceedingJoinPoint joinPoint) {
        String method = joinPoint.getTarget().getClass().getSimpleName() + "." + joinPoint.getSignature().getName() + "(..)";
        Object response = null;
        try {
            log.info("Service start. method : {} , Param : {}", method, Arrays.toString(joinPoint.getArgs()));
            response = joinPoint.proceed();
            log.info("Service finish. method : {}, Result : {}", method, response);
        } catch (Throwable e) {
            log.error("Service error. method : {} , Cause : {}", method, e);
        } finally {
        }
        return response;
    }

    // 一个方法会被处理成一个advisor的！！！
    @Before(value = "(execution(* com.example.spring.eventandjpa..*.*(..)))")
    public void service2() {
        log.info("BeforeBeforeBeforeBeforeBefore1111");
    }

    // 一个方法会被处理成一个advisor的！！！JoinPoint可用于@Before
    @Before(value = "(execution(* com.example.spring.eventandjpa..*.*(..)))")
    public void service3(JoinPoint point) {
        log.info("BeforeBeforeBeforeBeforeBefore2222" + point.getArgs());
    }

    public XxAdvice() {
        System.out.println("MyAdvicexx ----- 构造器执行啦");
    }

}
