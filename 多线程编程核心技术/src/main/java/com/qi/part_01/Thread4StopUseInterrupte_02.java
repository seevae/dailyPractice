package com.qi.part_01;/*
    name zhang;
    */


/**
 * 线程处于阻塞状态时调用interrupte方法
 *
 * 当线程处于休眠状态的时候,如果调用了该线程的中断方法
 * 则该线程会直接抛出中断异常
 * 我们只需要将该异常捕获就好
 *
 */

class MyThread_02 extends Thread{

    @Override
    public void run() {
        try{
            System.out.println("准备开始睡觉...");
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("睡觉结束了吗");
        }catch (Exception e){
            System.out.println("线程睡觉时被中断了~~~");
        }
    }
}

public class Thread4StopUseInterrupte_02 {

    public static void main(String[] args) throws InterruptedException {
        MyThread_02 myThread_02 = new MyThread_02();
        myThread_02.start();
        Thread.sleep(2000);
        myThread_02.interrupt();
    }
}
