package io.github.seevae.synchronizedtest;/*
    name zhang;
    */

////同步代码块
//class TicketTask implements Runnable{
//    private int ticket = 2000;
//    @Override
//    public void run() {
//        //解决一票多卖的方法: 任意时刻只有一个线程可以执行下面的一段代码
//        for (int i = 0; i < 2000; i++) {
//            //需要在判断处上锁
//            synchronized (this) {
//                //在任意一个时刻只有一个线程能进入条件的判断
//                if (this.ticket > 0) {
//                    try {
//                        //sleep模拟网络延迟
//                        Thread.sleep(200);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + "买票后," + "还剩下" + ticket-- + "票");
//                }
//            }
//        }
//    }
//}


//同步方法
class TicketTask implements Runnable{
    private int ticket = 2000;
    @Override
    public void run() {
        //解决一票多卖的方法: 任意时刻只有一个线程可以执行下面的一段代码
        for (int i = 0; i < 2000; i++) {
            //需要在判断处上锁
           sellTicket();
        }
    }

    public synchronized void sellTicket(){
        if(ticket>0){
            ticket--;
            System.out.println(Thread.currentThread().getName() + "买票后," + "还剩下" + ticket + "票");
        }
    }
}


public class SellTicket {
    public static void main(String[] args) {
        TicketTask ticketTask = new TicketTask();
        Thread thread = new Thread(ticketTask,"黄牛A");
        Thread thread1 = new Thread(ticketTask,"黄牛B");
        Thread thread2 = new Thread(ticketTask,"黄牛C");
        thread.start();
        thread1.start();
        thread2.start();
    }
}
