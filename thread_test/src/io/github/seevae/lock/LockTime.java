package io.github.seevae.lock;/*
    name zhang;
    */


import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TaskTime implements Runnable{

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        testA();
    }

    public void testA(){
        try {
            if (lock.tryLock(1,TimeUnit.SECONDS)){
                System.out.println(Thread.currentThread().getName()+"获取锁成功");
                Thread.sleep(500);
            }else{
                System.out.println(Thread.currentThread().getName()+"获取锁失败");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            lock.unlock();

        }

    }
}

public class LockTime {
    public static void main(String[] args) {
        TaskTime taskTime = new TaskTime();
        Thread thread1  = new Thread(taskTime);
        Thread thread2 = new Thread(taskTime);
        thread1.start();
        thread2.start();
    }
}
