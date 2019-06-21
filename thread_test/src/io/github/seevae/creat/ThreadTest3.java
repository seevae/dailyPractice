package io.github.seevae.creat;/*
    name zhang;
    */

import java.util.concurrent.*;

class CallableThread implements Callable<String>{
    private int ticket = 20;

    @Override
    //线程需要执行的任务 和run相同但是有返回值
    public String call() throws Exception {
        while(ticket>0){
            ticket--;
            System.out.println("当前线程为:"+Thread.currentThread().getName()+"还剩下"+ticket+"票");
        }
        return "票卖完了~客观明天再来";
    }

}

public class ThreadTest3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //产生Callable对象
        CallableThread callableThread = new CallableThread();
        //产生FutureTask对象
        FutureTask<String> futureTask = new FutureTask<>(callableThread);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }

}
