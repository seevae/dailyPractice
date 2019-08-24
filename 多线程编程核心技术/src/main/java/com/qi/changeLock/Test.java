package com.qi.changeLock;

//锁对象的改变
//一个线程进入共享资源后修改了共享资源的锁导致下一个线程竞争的锁资源改变
class Service{
    private String lock  = "123";
    public void testMthod(){
        try{
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+" 开始执行任务");
                lock="456";
                if(Thread.currentThread().getName().equals("A")){
                    System.out.println("锁修改完毕");
                }
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+" 任务执行完毕");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class ThreadA extends  Thread{
    private Service service;

    public ThreadA(Service service){
        this.service = service;
    }

    public void run(){
        service.testMthod();
    }
}


class ThreadB extends  Thread{
    private Service service;

    public ThreadB(Service service){
        this.service = service;
    }

    public void run(){
        service.testMthod();
    }
}

public class Test {
    public static void main(String[] args) {
        Service service = new Service();
        ThreadA threadA = new ThreadA(service);
        threadA.setName("A");
        ThreadB threadB = new ThreadB(service);
        threadB.setName("B");
        threadA.start();
        threadB.start();
    }
}
