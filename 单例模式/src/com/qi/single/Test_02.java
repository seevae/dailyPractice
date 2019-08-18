package com.qi.single;


/**
 * 懒汉式
 */


//这种方式只能在单线程的情况下使用,因为如果一个线程走到了if判断中还没有来及继续往下走,
// 另外一个线程就进入了,这时候俩个线程会产生两个实例,就不是单例模式了
class Single_01{

    private static Single_01 single = null;

    private Single_01(){

    }

    public static Single_01 getInstance(){
        if(single == null){
            single = new Single_01();
        }
        return single ;
    }

}

/**
 *
 *  懒汉式的安全写法
 *  这种方式虽然安全但是不推荐使用,因为效率太低了,每个线程在想获取类的实例的时候都需要执行getInstance方法
 *  但其实这个方法只需要执行一次就够了,有了实例之后其他线程直接取就好了
 *
 */

class Single_safe{

    private static Single_safe single_safe = null;

    private Single_safe(){

    }

    public static synchronized  Single_safe getInstance(){
        if(single_safe == null){
            single_safe = new Single_safe();
        }
        return  single_safe;
    }

}


//懒汉式,同步代码块的方式
/**
 * 因为方法上直接同步和执行的效率太低,所以使用同步代码块的方式
 * 但是这种方式并不能解决多线程下的单例问题
 * 因为还是有可能多个线程同时进入if语句,然后等待一个线程创建完对象之后再创建对象
 */
class Single_safe_02{
    private static Single_safe_02 single = null;

    private Single_safe_02(){

    }

    public static Single_safe_02 getInstance(){
        if(single == null){
            synchronized (Single_safe_02.class){
                single = new Single_safe_02();
            }
        }
        return single;
    }

}

//懒汉式双重检查
class Single_doubleCheck{

    private static Single_doubleCheck single = null;

    private Single_doubleCheck(){

    }

    public static Single_doubleCheck getInstance(){
        if(single == null){
            synchronized (Single_doubleCheck.class){
                if(single ==null){
                    single = new Single_doubleCheck();
                }
            }
        }
        return single;
    }
}


public class Test_02 {

}
