package com.zwonb;

/**
 * 访问构造方法
 * Created by zwonb on 2017/7/13.
 */
public class Example1 {

    String s;
    int i1, i2, i3;

    private Example1() {
    }

    protected Example1(String s, int i1) {
        this.s = s;
        this.i1 = i1;
    }

    public Example1(String... strings) throws NumberFormatException {
        if (strings.length > 0) {
            i1 = Integer.parseInt(strings[0]);
        }
        if (strings.length > 1) {
            i2 = Integer.parseInt(strings[1]);
        }
        if (strings.length > 2) {
            i3 = Integer.parseInt(strings[2]);
        }
    }

    public void print(){
        System.out.println("s="+s);
        System.out.println("i1=" + i1);
        System.out.println("i2=" + i2);
        System.out.println("i3=" + i3);
    }
}
