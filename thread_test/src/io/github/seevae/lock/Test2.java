package io.github.seevae.lock;/*
    name zhang;
    */


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//响应中断
class TaskInterupt implements Runnable{
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        try{
            while(true){
                lock.lockInterruptibly();
            }
        }catch (InterruptedException e){
            System.out.println("线程响应中断");
            return;
        } finally {
            lock.unlock();
        }
    }
}

public class Test2 {
    public static void main(String[] args) {
        TaskInterupt taskInterupt = new TaskInterupt();
        Thread thread = new Thread(taskInterupt);
        thread.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
