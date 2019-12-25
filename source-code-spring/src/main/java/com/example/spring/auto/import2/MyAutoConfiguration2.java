package com.example.spring.auto.import2;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * 研究import导入的类之间的顺序规则
 *
 * @date:2019/12/23 23:05
 **/
@Component
@Import({MyImportSelector2.class, MyBeanPostProcessor2.class,
        MyBeanDefinitionRegistryPostProcessor2.class, MyImportBeanDefinitionRegistrar2.class,
        MyComponent2.class, MyDeferredImportSelector2.class})
public class MyAutoConfiguration2 {


}

