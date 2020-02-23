package com.example.spring.eventandjpa.notransaction;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @date:2020/1/9 21:56
 **/
@Slf4j
@Aspect
@Component
public class MyAdvice3 {
    @Around(value = "(execution(* com.example.spring.eventandjpa..*.*(..)))")
    public Object service(ProceedingJoinPoint joinPoint) {
        String method = joinPoint.getTarget().getClass().getSimpleName() + "." + joinPoint.getSignature().getName() + "(..)";
        Object response = null;
        try {
            log.info("MyAdvice3 Service start. method : {} , Param : {}", method, Arrays.toString(joinPoint.getArgs()));
            response = joinPoint.proceed();
            log.info("MyAdvice3 Service finish. method : {}, Result : {}", method, response);
        } catch (Throwable e) {
            log.error("MyAdvice3 Service error. method : {} , Cause : {}", method, e);
        } finally {
        }
        return response;
    }

    public MyAdvice3() {
        System.out.println("MyAdvice3 ----- 构造器执行啦");
    }
}
