package com.qi.part_02;

/**
 * 可重入锁: 当一个线程获得了一个对象的锁之后,再次申请获取这个锁对象还是能够获得的到的,即自己可以再次获取自己的内部锁
 *
 * 当两个类有继承关系的时候,子类也是可以通过可重入锁调用父类的方法的
 */

class Play{

    public synchronized void playGame(){
        System.out.println("正在打游戏");
        try {
            Thread.sleep(3000);
            listen();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void listen(){
        System.out.println("正在听歌");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread{

    private Play play;

    public MyThread(Play play){
        this.play = play;
    }

    public void run(){
        play.playGame();
    }

}

public class 可重入锁 {

    public static void main(String[] args) {
        Play play = new Play();
        MyThread myThread = new MyThread(play);
        myThread.start();
    }
}
