package com.qi.volatile_01;

/*
   synchronized 代码块有volatile 同步的功能

 */
class Service{

    //1. 如果此处加上volatile变量值就可见了,线程运行可以停下来(使用synchronized代码块有同样功能)
    //2. volatile关键字要放在前面,不能放在变量类型的后面
    private  boolean isContinueRun = true;

    public void runMethod(){
       
        while(isContinueRun == true){
            //使用synchronized代码快实现多线程间变量的可见性
            String anything = new String();
            synchronized (anything){
                //synchronized不仅可以解决一个线程看到对象处于不一致的状态
                //还可以保证进入同步方法或者同步代码块的每个线程,都看到由同一个锁保护之前的所有修改效果
            }

        }
        System.out.println("停下来了");
    }

    public void setContinueRun(){
        isContinueRun = false;
    }
}

class MyThreadA extends Thread{

    private Service service;

    public MyThreadA(Service service){
        this.service = service;
    }

    public void run(){
        service.runMethod();
    }
}

class MyThreadB extends Thread{
    private Service service;

    public MyThreadB(Service service){
        this.service = service;
    }

    public void run(){
        service.setContinueRun();
    }

}

public class Test_4 {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        MyThreadA myThreadA = new MyThreadA(service);
        MyThreadB myThreadB = new MyThreadB(service);
        myThreadA.start();
        Thread.sleep(1000);
        myThreadB.start();
        System.out.println("已经发起终止的指令");
    }
}
