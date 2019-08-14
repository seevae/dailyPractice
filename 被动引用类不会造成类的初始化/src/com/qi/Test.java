package com.qi;


//通过子类引用父类的静态字段,不会导致子类的初始化
//对于静态字段,只有直接定义这个字段的类才会被初始化,因此通过其子类来调用父类中定义的静态字段,只会触发父类的初始化,而子类不会初始化
//至于子类是否要触发加载和验证,取决于具体虚拟机实现
class SuperClass{
    static{
        System.out.println("SuperClass init!");
    }

    public static void print(){
        System.out.println("SuperClass method");
    }

    public static int value = 10;
}

class SubClass extends SuperClass{

    static{
        System.out.println("SubClass init!");
    }
}

public class Test {

    public static void main(String[] args) {
        System.out.println(SubClass.value);
        SubClass.print();
    }
}
