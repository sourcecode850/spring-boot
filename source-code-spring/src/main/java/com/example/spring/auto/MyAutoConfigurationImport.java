package com.example.spring.auto;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * ConfigurationClassParser类中完成注入到BDM中
 * this.componentScanParser.parse(componentScan, sourceClass.getMetadata().getClassName())
 * <p>
 * 这里MyConfigByOtherImport已经通过@Configuration方式导入了，再在这里@Import导入似乎没用！！
 * <p>
 * 而且这里的出现在configClass中的顺序似乎是：
 * MyBeanMethodObj,MyConfigByOtherImport,MyAutoConfigurationImport
 * 其实这个时候，MyAutoConfigurationImport已经存在于BDM中了，而其他@Import导入的还没有
 * MyAutoConfigurationImport之所以还要存在于configClass中， 是因为可能需要处理其他registrar等
 * <p>
 * 注意：MyImportBeanDefinitionRegistrar本身并不会注入到BDM中，而是会执行registerBeanDefinitions方法，
 * 方法的中的第一个参数importingClassMetadata是指导入这个MyImportBeanDefinitionRegistrar所在的类的 信息
 * 这里就是MyAutoConfigurationImport的信息;
 * 而且MyImportBeanDefinitionRegistrar可以被多个注解类导入多次是没关系的
 **/
@Configuration
@Import({MyComponent.class, MyBeanPostProcessor.class,
        MyBeanDefinitionRegistryPostProcessor.class, MyImportBeanDefinitionRegistrar.class,
        MyImportSelector.class, MyDeferredImportSelector.class})
public class MyAutoConfigurationImport {

    public MyAutoConfigurationImport() {
        System.out.println("MyAutoConfigurationImport---------------------");
    }

}
