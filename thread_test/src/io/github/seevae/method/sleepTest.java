package io.github.seevae.method;/*
    name zhang;
    */

class Sleep implements  Runnable{

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+",i="+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class sleepTest {
    public static void main(String[] args) {
        Runnable runnable = new Sleep();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

