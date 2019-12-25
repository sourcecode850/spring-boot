package com.example.spring.auto;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.Ordered;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @date:2019/12/23 22:23
 **/
public class MyDeferredImportSelector implements DeferredImportSelector, Ordered {

    public MyDeferredImportSelector() {
        System.out.println("MyDeferredImportSelector构造器------------------");
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("MyDeferredImportSelector-------------------");
        return new String[]{MyDeferredImport1.class.getName()};
    }

    // 加上与AutoConfigurationImportSelector一样的优先级
    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 1;
    }
}
