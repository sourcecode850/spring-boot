package com.example.spring.auto.import2;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @date:2019/12/23 22:18
 **/
public class MyImportSelector2 implements ImportSelector {
    public MyImportSelector2() {
        System.out.println("MyImportSelector2构造器----------------");
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("MyImportSelector2--------------------------importingClassMetadata");
        return new String[]{MyImport2.class.getName()};
    }
}
