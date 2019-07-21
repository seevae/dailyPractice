package com.qi.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Sellticket implements Runnable{

    private Integer ticket = 20;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try{
                lock.lock();
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"开始购票..." + "当前有车票" +ticket--+"张");
                    System.out.println("还剩车票"+ticket+"张");
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
        System.out.println("车票已卖完");
    }
}

public class SellTicketsTestLock {
    public static void main(String[] args) {
        Runnable runnable = new Sellticket();
        Thread thread1 = new Thread(runnable,"小A");
        Thread thread2 = new Thread(runnable,"小B");
        Thread thread3 = new Thread(runnable,"小C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
