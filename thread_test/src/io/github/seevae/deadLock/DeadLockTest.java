package io.github.seevae.deadLock;/*
    name zhang;
    */


/**
 *
 *
 */
public class DeadLockTest {

    private static Object work = new Object();
    private static Object money = new Object();

    public static void main(String[] args) {

        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {
                //将自己锁住
                synchronized (work){
                    System.out.println("先给钱,我在工作");
                    //尝试访问资源
                    synchronized (money){
                        System.out.println("给我钱");
                    }
                }
            }
        });

        Thread boss = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (money){
                    System.out.println("先干活,再给钱");
                    synchronized (work){
                        System.out.println("去干活");
                    }
                }
            }
        });


        worker.start();
        boss.start();
    }
}
