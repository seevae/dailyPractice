package io.github.seevae.method;/*
    name zhang;
    */

class Yield implements  Runnable{

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            try {
                Thread.yield();
                System.out.println(Thread.currentThread().getName()+",i="+i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class YieldTest {
    public static void main(String[] args) {
        Runnable yield = new Yield();
        Thread thread1 = new Thread(yield);
        Thread thread2 = new Thread(yield);
        Thread thread3 = new Thread(yield);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
