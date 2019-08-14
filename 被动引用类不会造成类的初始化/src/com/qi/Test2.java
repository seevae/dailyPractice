package com.qi;


//被final修饰的常量在编译阶段会存入调用类的常量池中,本质上并没有直接引用到定义常量的类,因此不会发生类的初始化
class ConstClass{

    static{
        System.out.println("ConstClass init!");
    }

    public static final String str = "hello world";
}

public class Test2 {

    public static void main(String[] args) {
        System.out.println(ConstClass.str);
    }
}
