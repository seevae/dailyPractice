package com.qi.thread;/*
    name zhang;
    */


class SellTicket implements Runnable{

    private Integer count= 50;
    private Object obj = new Object();

    @Override
    public void run() {

        while(count > 0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj){
                if(count>0){
                    System.out.println(Thread.currentThread().getName()+"开始购票...  "+"当前有车票:"+this.count+"张");
                    count--;
                    System.out.println("还剩余车票"+count);
                }
            }
        }
        System.out.println("票已卖完!");
    }

}

public class SellTicketsTest {
    public static void main(String[] args) {

        Runnable runnable = new SellTicket();
        Thread thread1 =new Thread(runnable,"黄牛A");
        Thread thread2 =new Thread(runnable,"黄牛B");
        Thread thread3 =new Thread(runnable,"黄牛C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
