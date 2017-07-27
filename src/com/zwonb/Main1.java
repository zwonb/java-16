package com.zwonb;

import java.lang.reflect.Constructor;

/**
 * 访问构造方法
 * Created by zwonb on 2017/7/13.
 */
public class Main1 {

    public static void main(String[] args) {
        Example1 example = new Example1("10", "20", "30");
        Class<? extends Example1> exampleClass = example.getClass();
        //获得所有构造方法
        Constructor<?>[] declaredConstructors = exampleClass.getDeclaredConstructors();
        for (int i = 0; i < declaredConstructors.length; i++) {
            //遍历获取每一个构造方法
            Constructor<?> constructor = declaredConstructors[i];
            System.out.println("查看是否允许带有可变数量的参数：" + constructor.isVarArgs());
            System.out.println("该构造方法的入口参数类型依次为：");
            //获得所有参数类型
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                System.out.println(parameterTypes[j]);
            }
            Example1 example1 = null;
            while (example1 == null) {
                //如果该成员变量的访问权限为private，则抛出异常，既不允许访问
                try {
                    if (i == 2) {
                        //通过执行具有默认没有参数的构造方法创建对象
                        example1 = (Example1) constructor.newInstance();
                    } else if (i == 1) {
                        //通过执行具有两个参数的构造方法创建对象
                        example1 = (Example1) constructor.newInstance("7", 5);
                    } else {
                        //通过执行具有可变数量参数的构造方法创建对象
                        Object[] parameters = new Object[]{new String[]{"100", "200", "300"}};
                        example1 = (Example1) constructor.newInstance(parameters);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    //设置private的构造方法允许使用newInstance()获得对象
                    constructor.setAccessible(true);
                }
            }
            if (example1 != null) {
                example1.print();
                System.out.println();
            }
        }

    }
}
