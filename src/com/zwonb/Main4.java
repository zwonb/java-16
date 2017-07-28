package com.zwonb;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 注解访问
 * Created by zyb on 2017/7/28.
 */
public class Main4 {

    public static void main(String[] args) {
        Record record = new Record();
        Class<? extends Record> recordClass = record.getClass();
        //获得所有的构造方法
        Constructor<?>[] declaredConstructors = recordClass.getDeclaredConstructors();
        for (int i = 0; i < declaredConstructors.length; i++) {
            Constructor<?> constructor = declaredConstructors[i];
            //查看是否具有类型的注解
            if (constructor.isAnnotationPresent(ConsAnnotation.class)) {
                ConsAnnotation annotation = constructor.getAnnotation(ConsAnnotation.class);
                //获得注解信息
                System.out.println(annotation.value());
            }
            //获得参数的注解
            Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
            for (int j = 0; j < parameterAnnotations.length; j++) {
                //获取指定参数注解的长度
                int length = parameterAnnotations[j].length;
                if (length == 0) {
                    System.out.println("未添加Annotation的参数");
                }else {
                    for (int k = 0; k < length; k++) {
                        //获得参数的注解
                        FMPAnnotation annotation = (FMPAnnotation)parameterAnnotations[j][k];
                        System.out.println(annotation.describe());
                        System.out.println(annotation.type());
                    }
                }
                System.out.println();
            }
        }

        //获得所有字段
        Field[] declaredFields = recordClass.getDeclaredFields();
        for (int i = 0; i < declaredConstructors.length; i++) {
            Field field = declaredFields[i];
            if (field.isAnnotationPresent(FMPAnnotation.class)) {
                //获得指定类型的注解
                FMPAnnotation annotation = field.getAnnotation(FMPAnnotation.class);
                //获得注解的信息
                System.out.println(annotation.describe());
                System.out.println(annotation.type());
            }
        }

        //获得所有方法
        Method[] declaredMethods = recordClass.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            Method method = declaredMethods[i];
            if (method.isAnnotationPresent(FMPAnnotation.class)) {
                //获得指定类型的注解
                FMPAnnotation annotation = method.getAnnotation(FMPAnnotation.class);
                System.out.println(annotation.describe());
                System.out.println(annotation.type());
            }

            //获得参数的注解
            //一个参数可以有多个注解，所以参数的注解返回是一个二维数组
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            for (int j = 0; j < parameterAnnotations.length; j++) {
                int length = parameterAnnotations[j].length;
                if (length == 0) {
                    System.out.println("未添加Annotation参数");
                }else {
                    for (int k = 0; k < length; k++) {
                        //获得指定类型的注解
                        FMPAnnotation annotation = (FMPAnnotation) parameterAnnotations[j][k];
                        //获得参数的注解信息
                        System.out.println(annotation.describe());
                        System.out.println(annotation.type());
                    }
                }
                System.out.println();
            }
        }

    }
}
