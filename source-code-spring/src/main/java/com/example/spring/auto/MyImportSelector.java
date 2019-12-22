package com.example.spring.auto;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @date:2019/12/23 22:18
 **/
public class MyImportSelector implements ImportSelector {
    public MyImportSelector() {
        System.out.println("MyImportSelector构造器----------------");
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("MyImportSelector--------------------------importingClassMetadata");
        return new String[0];
    }
}
