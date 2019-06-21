package io.github.seevae.method;/*
    name zhang;
    */


class DaemonTest implements Runnable{

    @Override
    public void run() {
        while(true){
            System.out.println("当前线程是否是守护线程"+Thread.currentThread().isDaemon());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("当前线程是否是守护线程"+Thread.currentThread().isDaemon());
                System.out.println("线程被终止");
                return;
            }
        }
    }
}

public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        DaemonTest daemonThread = new DaemonTest();
        Thread thread1 = new Thread(daemonThread);
        Thread thread2 = new Thread(daemonThread);
        thread1.setDaemon(true);
        thread1.start();
        thread2.start();
        Thread.sleep(3000);
        thread2.interrupt();
        Thread.sleep(5000);
        System.out.println("代码结束");
    }
}
