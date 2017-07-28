package com.zwonb;

import java.lang.reflect.Method;

/**
 * 反射访问方法
 * Created by zyb on 2017/7/28.
 */
public class Main3 {

    public static void main(String[] args) {
        Example3 example = new Example3();
        Class<? extends Example3> exampleClass = example.getClass();
        Method[] declaredMethods = exampleClass.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            Method method = declaredMethods[i];
            //获得方法名称
            System.out.println("名称为：" + method.getName());
            System.out.println("是否允许带有可变参数：" + method.isVarArgs());

            System.out.println("入口参数类型依次为：");
            //获得所有参数类型
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                System.out.println(parameterTypes[j]);
            }
            //获得方法返回值类型
            System.out.println("返回值类型为：" + method.getReturnType());

            System.out.println("可能抛出的异常有：");
            //获得方法可能抛出的异常类型
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            for (int j = 0; j < exceptionTypes.length; j++) {
                System.out.println(exceptionTypes[j]);
            }
            boolean isTurn = true;
            while (isTurn){
                //如果方法的访问权限为private，则抛出异常，即不允许访问
                try {
                    isTurn = false;
                    if (method.getName().equals("staticMethod")) {
                        //执行没有入口参数的方法
                        method.invoke(example);
                    } else if (method.getName().equals("publicMethod")) {
                        System.out.println("返回值为："+method.invoke(example, 168));
                    } else if (method.getName().equals("protectedMethod")) {
                        System.out.println("返回值为："+method.invoke(example, "7", 5));
                    } else if (method.getName().equals("privateMethod")) {
                        //在反射中执行具有可变数量的参数的方法时，需要将入口参数定义为二维数组
                        Object[] parameters = new Object[]{new String[]{"M","W","Q"}};
                        System.out.println("返回值为："+method.invoke(example, parameters));
                    }
                } catch (Exception e) {
                    System.out.println("在执行方法是抛出异常，下面执行setAccessible方法");
                    //设为允许访问权限
                    method.setAccessible(true);
                    isTurn = true;
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }
}
