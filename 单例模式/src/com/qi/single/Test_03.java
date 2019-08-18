package com.qi.single;

/**
 * 使用静态内部类的方式实现单例模式
 *
 *  方法:
 *      在类的内部创建一个内部类,设置为私有的(为了能够在静态方法getInstance中使用这个静态类还要使用static修饰)
 *      该内部类中有一个属性即单例的实例,使用final修饰其为静态变量,唯一引用不会在更改
 *      在创建实例的方法中直接调用该静态类的属性便可以拿到单例对象
 *
 *  这种方法和前面的静态代码块的方式区别在于静态代码块是在类加载的时候就完成了对象的创建容易浪费资源
 *  而这种方式只有在调用内部类中的属性对象的时候才会进行对象的初始化,不会浪费资源
 *
 */

class Single{

    private Single(){}

    private static class SingleToInstance{
        private static final Single instance = new Single();
    }

    public static Single getInstance(){
        return SingleToInstance.instance;
    }
}

public class Test_03 {

    public static void main(String[] args) {
        System.out.println(Single.getInstance()==Single.getInstance());
    }
}