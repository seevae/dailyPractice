package com.qi.part_02;

class Service{
    private String name;
    private String password;
    private String strLock = new String();  //公共锁写在外部
    public void setNameAndPassword(String name,String password){
          try{
              synchronized(strLock){
                  System.out.println("当前线程是: "+Thread.currentThread().getName()+" 开始设置名字和密码");
                  this.name = name;
                  this.password = password;
                  System.out.println("当前线程是: "+Thread.currentThread().getName()+" 结束设置工作");
              }
          }  catch (Exception e){
              e.printStackTrace();
          }
    }
}

class MyThreadA extends Thread{
    private Service service;
    public MyThreadA(Service service){
        this.service = service;
    }

    public void run(){
        service.setNameAndPassword("aa","qqqqqq");
    }
}

class MyThreadB extends Thread{
    private Service service;
    public MyThreadB(Service service){
        this.service = service;
    }

    public void run(){
        service.setNameAndPassword("bb","wwwwwwww");
    }
}

public class 非this的对象锁 {
    public static void main(String[] args) {
        Service service = new Service();
        MyThreadA myThreadA = new MyThreadA(service);
        MyThreadB myThreadB = new MyThreadB(service);
        myThreadA.start();
        myThreadB.start();
    }
}