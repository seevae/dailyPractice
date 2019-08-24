package com.qi.volatile_01;


/**
 * 使用setRunning方法后,在堆栈中isRunning 的值已经被修改为了 false
 * 但是在JVM -Service状态下, 为了提高效率,线程取值都是从私有堆栈中取的
 * 这就导致了私有堆栈中的值和公有堆栈中的值不同步的问题
 * 使用volatile关键,可以使线程强制从公共堆栈中取值
 *
 */
class RunThread extends Thread{
    private volatile boolean isRunning = true;
    public  boolean isRunning(){
        return this.isRunning;
    }
    public void setRunning(boolean isRunning){
        System.out.println("该方法被使用了");
        this.isRunning = isRunning;
    }
    public void run(){
        System.out.println("进入了run");
        while(isRunning() == true){

        }
        System.out.println("线程被停止了");
    }
}


public class Test_02 {
    public static void main(String[] args) {
        RunThread runThread = new RunThread();
        runThread.start();
        try {
            Thread.sleep(1000);
            runThread.setRunning(false);
            System.out.println("已经被赋值为false");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
