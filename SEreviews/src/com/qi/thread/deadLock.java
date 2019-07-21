package com.qi.thread;/*
    name zhang;
    */

/**
 * 一个死锁的例子
 * 死锁的条件
 * 1.互斥: 共享资源只能够被一个线程占有  -->eg: 不论是pen还是book对象都只能够被一个线程所占有
 * 2.占有且等待: 线程A已经获得共享资源X,在等待获取资源Y的时候不释放资源X  -->eg: 第一个线程在获得资源pen,申请获取资源book时不释放pen
 * 3.不可抢占: 线程A在获取了pen资源后,其他线程不可以抢占该资源
 * 4.循环等待: 线程A等待资源book,线程B等待资源pen
 *
 * 使用Lock体系可以解决线程的死锁问题
 */

class Pen{}
class Book{}

public class deadLock {

    public static void main(String[] args) {
        Pen pen = new Pen();
        Book book = new Book();
        Thread thread1 = new Thread(()->{
            synchronized (pen){
                System.out.println("我有笔,我要一个本子");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (book){
                    System.out.println("好了,我有笔也有本子了");
                }
            }
        });

        Thread thread2 = new Thread(()->{
            synchronized (book){
                System.out.println("我有本子,我要一支笔");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (pen){
                    System.out.println("好了,我有本子也有笔了");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
