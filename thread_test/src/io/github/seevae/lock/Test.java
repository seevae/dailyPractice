package io.github.seevae.lock;/*
    name zhang;
    */


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Tasl implements Runnable{

    private int ticket = 10000;
    private Lock ticketLock = new ReentrantLock();

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            try{
                ticketLock.lock();
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"还剩下"+ticket--+"票");
                }
            }finally {
                ticketLock.unlock();
            }
        }
    }
}

public class Test {

}
