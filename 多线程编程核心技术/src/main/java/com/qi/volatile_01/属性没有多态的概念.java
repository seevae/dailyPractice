package com.qi.volatile_01;/*
    name zhang;
    */


class A{
    public int i=1;
}

class B extends A{
    public int i=2;
}

public class 属性没有多态的概念 {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.i);
    }
}
