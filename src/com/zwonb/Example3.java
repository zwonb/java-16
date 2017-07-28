package com.zwonb;

/**
 * 访问方法
 * Created by zyb on 2017/7/28.
 */
public class Example3 {

    static void staticMethod() {
        System.out.println("执行staticMethod方法");
    }

    public int publicMethod(int i) {
        System.out.println("执行publicMethod方法");
        return i * 100;
    }

    protected int protectedMethod(String s, int i) throws NumberFormatException {
        System.out.println("执行protectedMethod方法");
        return Integer.parseInt(s) + i;
    }

    private String privateMethod(String... strings){
        System.out.println("执行privateMethod方法");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            stringBuffer.append(strings[i]);
        }
        return stringBuffer.toString();
    }

}
