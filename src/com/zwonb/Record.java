package com.zwonb;

/**
 * Created by zyb on 2017/7/28.
 */
public class Record {

    //注释字段
    @FMPAnnotation(describe = "编号", type = int.class)
    int id;

    @FMPAnnotation(describe = "姓名", type = String.class)
    String name;

    //注释构造方法
    @ConsAnnotation
    public Record() {

    }

    @ConsAnnotation("立即初始化构造方法")
    public Record(@FMPAnnotation(describe = "编号", type = int.class) int id,
                  @FMPAnnotation(describe = "姓名", type = String.class) String name) {
        this.id = id;
        this.name = name;
    }

    @FMPAnnotation(describe = "获得编号",type = int.class)
    public int getId() {
        return id;
    }

    @FMPAnnotation(describe = "设置编号",type = int.class)
    public void setId(@FMPAnnotation(describe = "编号",type = int.class) int id) {
        this.id = id;
    }

    @FMPAnnotation(describe = "获得姓名",type = String.class)
    public String getName() {
        return name;
    }

    @FMPAnnotation(describe = "设置姓名",type = String.class)
    public void setName(@FMPAnnotation(describe = "姓名",type = String.class) String name) {
        this.name = name;
    }

}
