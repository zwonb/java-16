package com.zwonb;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于构造方法的注解
 * Created by zyb on 2017/7/28.
 */
//在构造方法中使用
@Target(ElementType.CONSTRUCTOR)
//运行时加载 Annotation 到 JVM 中，可以通过反射获取相关信息
@Retention(RetentionPolicy.RUNTIME)
public @interface ConsAnnotation {
    //定义一个具有默认值的String型成员
    String value() default "默认构造方法";
}
