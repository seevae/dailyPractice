package com.qi.gc_01;

class A{
    public Object object = null;
}

public class 引用记数法 {

    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        a1.object = a2;
        a2.object = a1;
        a1=null;
        a2=null;

        System.gc();
    }
}
