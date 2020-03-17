package com.example.spring.auto.import2;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @date:2019/12/22 21:50
 **/
public class MyImportBeanDefinitionRegistrar2 implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        System.out.println("MyImportBeanDefinitionRegistrar2--------------------------importingClassMetadata");
    }
}
