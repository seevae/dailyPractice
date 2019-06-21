package io.github.seevae.method;/*
    name zhang;
    */

class MyThread implements Runnable{

    private boolean flag = true;

    public void setFlag(boolean flag){
        this.flag = flag;
    }

    @Override
    public void run() {
        int i=0;
        while(flag){
            try {
                Thread.sleep(200);
                boolean bool = Thread.currentThread().isInterrupted();
                if(bool){
                    System.out.println("线程已被设置为中断状态");
                    return;
                }
                System.out.println("当前线程的状态值为"+bool);
                System.out.println(Thread.currentThread().getName()+","+i);
                i++;
            } catch (InterruptedException e) {
                System.out.println("抛出中断异常");
                return;
            }
        }
        System.out.println("线程停止");
    }
}

public class ThreadStop {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        //myThread.setFlag(false);
    }
}
