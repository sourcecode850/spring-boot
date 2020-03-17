package com.example.spring.xxaop;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * 代理对象的 @PostConstruct 还是会被执行的
 *
 * @date:2020/1/7 23:16
 **/
@Component
public class MyAopTransaction {

    @Transactional
    public void save() {
        return;
    }

    @PostConstruct
    public void print() {
        System.out.println("@PostConstruct---com.example.spring.aop.MyAopTransaction#print()");
    }

}

