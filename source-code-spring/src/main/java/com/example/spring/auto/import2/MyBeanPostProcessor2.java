package com.example.spring.auto.import2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 自定义的BeanPostProcessor需要手动通过注解等方式注入到BDM中
 *
 * @date:2019/12/22 23:08
 **/
public class MyBeanPostProcessor2 implements BeanPostProcessor {

    public MyBeanPostProcessor2() {
        System.out.println("MyBeanPostProcessor2构造器-------------");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor2----------------postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor2----------------postProcessAfterInitialization");
        return bean;
    }

}
