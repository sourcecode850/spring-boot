package com.example.spring.eventandjpa;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * @date:2020/1/8 23:35
 **/
@Component
public class MyAopInterceptByAdvice {

    @Transactional
    public void save() {
        return;
    }

    @PostConstruct
    public void print() {
        System.out.println("@PostConstruct---com.example.spring.aop.MyAopTransaction#print()");
    }

    public MyAopInterceptByAdvice() {
        System.out.println("MyAopInterceptByAdvice");
    }
}
