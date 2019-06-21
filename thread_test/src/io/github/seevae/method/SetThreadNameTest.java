package io.github.seevae.method;/*
    name zhang;
    */


class MyThread1 implements Runnable{

    public MyThread1(){

    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+",i="+i);
        }
    }
}

public class SetThreadNameTest {

    public static void main(String[] args) {
        //如果不自己设置名字,JVM也会自己帮我们起名
        MyThread1 myThread = new MyThread1();
        Thread thread1  = new Thread(myThread,"线程A");
        Thread thread2 = new Thread(myThread);
        thread2.setName("线程B");
        thread1.start();
        thread2.start();
    }
}
