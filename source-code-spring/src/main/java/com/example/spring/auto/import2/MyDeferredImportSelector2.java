package com.example.spring.auto.import2;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.Ordered;
import org.springframework.core.type.AnnotationMetadata;

public class MyDeferredImportSelector2 implements DeferredImportSelector, Ordered {

    public MyDeferredImportSelector2() {
        System.out.println("MyDeferredImportSelector2构造器------------------");
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("MyDeferredImportSelector-------------------");
        return new String[]{MyDeferredImport2.class.getName()};
    }

    // 加上与AutoConfigurationImportSelector一样的优先级
    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 1;
    }
}