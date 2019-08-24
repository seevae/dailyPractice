package com.qi.volatile_01;

/**
 * volatile不具有原子性
 * 此时保证了可见性,每一个线程拿到的count值都是公共内存中的值,但是没有保证原子性,各个线程的执行还是非同步的
 * 如果线程同步执行,需要给addCount()方法加上synchronized修饰符,但是加上之后也就没必要使用valotile来修饰变量了
 */

class MyThread extends Thread{

    public static volatile int count;

    private static  void addCount() throws InterruptedException {
        Thread.sleep(1000);
        for(int i=0;i<100;i++){
            count++;
            System.out.println("当前线程是: "+Thread.currentThread().getName()+" count = "+count);
        }
    }

    public void run(){
        try {
            addCount();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Test_03 {
    public static void main(String[] args) {
        MyThread[] myThreads = new MyThread[100];
        for(int i=0;i<100;i++){
            myThreads[i] = new MyThread();
        }

        for(int i=0;i<myThreads.length;i++){
            myThreads[i].start();
        }
    }
}
