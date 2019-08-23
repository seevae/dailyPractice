package com.qi.part_01;/*
    name zhang;
    */


/**
 * 使用interrupte 的方式停止线程(线程没有处于阻塞状态) -->此方式有点像标记法停止线程
 *
 * 当线程中断的标识变为已经要中断的状态时,抛出中断异常停止线程
 *
 * 不用break的原因: 如下面例子,如果仅仅只是使用break语句,那么循环跳出后
 * 还是要执行for语句下面部分的代码, 还是没有起到中断线程的作用
 */

class MyThread extends Thread{

    @Override
    public void run() {

        try{
            for(int i=0;i<500000;i++){
                if(this.isInterrupted()){
                    throw new InterruptedException();
                }
                System.out.println(i);
            }
            System.out.println("for循环外部的世界");

        }catch (Exception e){
            System.out.println("线程终止的命令我已经接收到了!");
        }

    }
}

public class Thread4StopUseInterrupte {

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        System.out.println("程序执行完毕");
    }
}
