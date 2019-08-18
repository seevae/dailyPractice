package com.qi.single;


/**
 * 饿汉式 两种方法
 *  1.直接在对象变量定义过后初始化
 *  2.在静态代码块中对对象变量初始化
 *
 * 优点:  这两种写法都比较简单,在类装载的时候就完成实例化,避免了线程同步问题
 * 缺点: 在类装载的时候就完成实例化,没有达到懒加载的效果,如果这个对象从未被使用就会造成内存的浪费
 *
 */
class Single1 {

    //static修饰保证在getInstance静态方法中可以拿到该对象
    //一旦被final修饰,代表着对象引用指向的地址不会再被改变,所以只有这一个single对象,是一个静态常量
    private static final Single1 single = new Single1();

    private Single1(){
    }

    public static Single1 getInstance(){
        return single;
    }
}


//静态代码块中初始化
class Single2{

    private static Single2 single2 = null;

    static{
        single2 = new Single2();
    }

    private Single2(){

    }

    public static Single2 getInstance(){
        return single2;
    }

}

//测试
public class Test_01 {

    public static void main(String[] args) {
        Single1 single1 = Single1.getInstance();
        Single1 single = Single1.getInstance();
        System.out.println(single == single1);

        Single2 single2 = Single2.getInstance();
        Single2 single21 = Single2.getInstance();
        System.out.println(single2 == single21);
    }
}
