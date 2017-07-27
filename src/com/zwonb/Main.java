package com.zwonb;

import java.util.Arrays;

public class Main implements Runnable,CharSequence {
    public Main(String s) {
    }

    public static void main(String[] args) {
        System.out.println(Main.class.getPackage());
        System.out.println(Main.class.getName());
        System.out.println(Main.class.getSuperclass());
        System.out.println(Arrays.toString(Main.class.getInterfaces()));
        System.out.println(Arrays.toString(Main.class.getConstructors()));
        System.out.println(Arrays.toString(Main.class.getDeclaredConstructors()));
        System.out.println(Arrays.toString(Main.class.getMethods()));
    }

    @Override
    public void run() {

    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}
