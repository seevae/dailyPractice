package io.github.seevae.creat;/*
    name zhang;
    */


class MyThread extends Thread{
    private String title;
    private int ticket = 20;

    public MyThread(String title){
        this.title = title;
    }

    @Override
    public void run() {
        while(ticket>0){
            ticket--;
            System.out.println("当前线程为:"+title+","+"票还剩余:"+ticket);
        }
    }

}

public class ThreadTest {

    public static void main(String[] args) {
        MyThread myThread = new MyThread("黄牛A");
        MyThread myThread2 = new MyThread("黄牛B");
        MyThread myThread3 = new MyThread("黄牛C");
        myThread.start();
        myThread2.start();
        myThread3.start();
    }
}
