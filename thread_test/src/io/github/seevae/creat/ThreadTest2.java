package io.github.seevae.creat;/*
    name zhang;
    */

class MyThread1 implements Runnable{

    private int ticket = 20;

    public MyThread1(){

    }

    @Override
    public void run() {
        while(ticket>0){
            ticket--;
            System.out.println("当前线程为:"+Thread.currentThread().getName()+","+"票还剩余:"+ticket);
        }
    }
}

public class ThreadTest2 {

    public static void main(String[] args) {
        MyThread1 myThread = new MyThread1();
//        MyThread1 myThread2 = new MyThread1("子程序2");
//        MyThread1 myThread3 = new MyThread1("子程序2");
        Thread thread1  = new Thread(myThread);
        Thread thread2 = new Thread(myThread);
        Thread thread3 = new Thread(myThread);
        thread1.start();
        thread2.start();
        thread3.start();

    }
}