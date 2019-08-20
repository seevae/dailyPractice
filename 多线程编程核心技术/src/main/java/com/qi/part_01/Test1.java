package com.qi.part_01;


/**
 * main方法也是一个线程.他是由JVM自己创建的
 */
public class Test1 {

    public static void main(String[] args) {
        String name = Thread.currentThread().getName();
        System.out.println(name);
    }
}
