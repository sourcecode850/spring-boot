package com.example.spring.auto;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @date:2019/12/23 22:23
 **/
public class MyDeferredImportSelector implements DeferredImportSelector {

    public MyDeferredImportSelector() {
        System.out.println("MyDeferredImportSelector构造器------------------");
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("MyDeferredImportSelector-------------------");
        return new String[]{MyDeferredImport1.class.getName()};
    }

}
