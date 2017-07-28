package com.zwonb;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于字段方法和参数的注解
 * Created by zyb on 2017/7/28.
 */
//用于字段方法和参数
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FMPAnnotation {
    //定义一个没有默认值的String型成员
    String describe();
    //定义一个具有默认值的class成员
    Class type() default Void.class;
}
