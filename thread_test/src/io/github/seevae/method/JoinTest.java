package io.github.seevae.method;/*
    name zhang;
    */

class Join implements  Runnable{

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

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始");
        Runnable runnable = new Join();
        Thread thread1 = new Thread(runnable);
//        Thread thread2 = new Thread(runnable);
//        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread1.join();
//        thread2.start();
//        thread3.start();
        System.out.println("主线程执行完毕");
    }
}
