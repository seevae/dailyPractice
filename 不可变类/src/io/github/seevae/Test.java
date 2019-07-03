package io.github.seevae;/*
    name zhang;
    */

import java.util.Date;

/**
 * 自定义一个不可变类
 * 1.类中所有成员变量被private修饰
 * 2.类中不能提供从外界修改属性值的方法,不能有setXxx,只提供构造函数,一次生成,永不改变
 * 3.确保类中所有方法不能被子类覆写,使用final修饰方法或类
 * 4.如果一个类成员不是不可变量,那么在成员初始化或者使用get方法获取该成
 *   员变量时.需要通过clone来确保类的不可变
 */

class ImmutableClass{
    //1
    private Date date;

    //2
    public ImmutableClass(Date date){
        this.date = (Date)date.clone();
    }

    //3
    public final void  printState(){
        System.out.println(date);
    }

    //4
    public final Date getDate(){
        return (Date) this.date.clone();
    }

}

public class Test {
    public static void main(String[] args) {
        Date date = new Date();
        ImmutableClass immutableClass = new ImmutableClass(date);
        immutableClass.printState();
    }
}
