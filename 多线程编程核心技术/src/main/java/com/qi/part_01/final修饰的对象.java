package com.qi.part_01;

class Person{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class final修饰的对象 {

    public static void main(String[] args) {
        final Person p = new Person();
        p.setName("zhangsan");

        //被final修饰过后的对象为不可变对象,他的引用永远指向一块内存空间,不可更改
        //p = new Person();
        System.out.println();
    }
}
