package com.zwonb;

import java.io.File;
import java.lang.reflect.Field;

/**
 * 反射获取成员变量
 * Created by zwonb on 2017/7/27.
 */
public class Main2 {

    public static void main(String[] args) {
        Example2 example = new Example2();
        Class<? extends Example2> exampleClass = example.getClass();
        Field[] declaredFields = exampleClass.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            //获得成员变量的名称
            System.out.println("名称为：" + field.getName());
            //获得成员变量的类型
            Class<?> fieldType = field.getType();
            System.out.println("成员变量的类型为:" + fieldType);
            boolean isTurn = true;
            while (isTurn) {
                //如果成员变量是的访问权限为private,则抛出异常，即不允许访问
                try {
                    isTurn = false;
                    System.out.println("修改前的值为：" + field.get(example));
                    //判断成员变量的类型是否为int型
                    if (fieldType.equals(int.class)) {
                        System.out.println("利用方法setInt()修改成员变量的值");
                        field.setInt(example, 168);
                    } else if (fieldType.equals(float.class)) {
                        System.out.println("利用方法setFloat()修改成员变量的值");
                        field.setFloat(example, 99.9f);
                    } else if (fieldType.equals(boolean.class)) {
                        System.out.println("利用方法setBoolean()修改成员变量的值");
                        field.setBoolean(example, true);
                    } else {
                        System.out.println("利用方法set()修改成员变量的值");
                        //可以为各种类型的成员变量赋值
                        field.set(example, "MWQ");
                    }

                    //获得成员变量值
                    System.out.println("修改后的成员变量值为：" + field.get(example));
                } catch (IllegalAccessException e) {
                    System.out.println("在设置成员变量值时抛出异常，下面执行setAccessible()方法！");
                    //设置为允许访问
                    field.setAccessible(true);
                    isTurn = true;
                    e.printStackTrace();
                }
            }


        }
    }
}
