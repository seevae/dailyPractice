package com.qi.ThreadPoolExecutor_01;

import java.util.concurrent.*;


class MyThread implements Runnable{

    private int tickets = 20;
    @Override
    public void run() {
        System.out.println("当前线程为 "+Thread.currentThread().getName()+"准备开始购票");
        try {
            while(tickets > 0){
                Thread.sleep(1000);
                synchronized (this){
                    if(tickets >0){
                        tickets--;
                        System.out.println(Thread.currentThread().getName()+" 购票完成"+"还剩余"+this.tickets+" 张票");
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Test {

    public static void main(String[] args) {

        //创建一个线程池
        /**
         * 各参数的意义(顺序解释)
         *
         * 核心线程池的大小,最大线程池的大小,线程空闲时存活时间,存活时间的单位,阻塞队列
         * 饱和策略不指定,默认使用AbortPolicy,饱和时直接抛出异常
         *
         */
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                3,5,2000,
                TimeUnit.MICROSECONDS,
                new LinkedBlockingDeque<Runnable>());

        //使用execute()方法提交任务
        // execute方法没有返回值,且需要一个Runnable实例对象作为参数
        MyThread myThread = new MyThread();
        for(int i=0;i<5;i++){
            poolExecutor.execute(myThread);
        }

        poolExecutor.shutdown();
        System.out.println(poolExecutor.isTerminated());
    }
}
