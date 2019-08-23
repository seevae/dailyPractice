package com.qi.ThreadPoolExecutor_01;
import java.util.concurrent.*;

class MyThread_02 implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println("当前线程是: "+Thread.currentThread().getName());
        Thread.sleep(1000);
        return Thread.currentThread().getName()+"执行成功";
    }
}

public class Test_02 {
    public static void main(String[] args) throws Exception {

        //创建线程池
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3,5,2000,
                TimeUnit.MICROSECONDS,new LinkedBlockingDeque<Runnable>());

        //使用submit的方式提交任务,任务执行后会返回一个Future对象.
        //使用Future对象的get()方法可以获取返回值,get()方法会阻塞线程直到任务结束
        MyThread_02 myThread02 = new MyThread_02();

        for(int i=0;i<5;i++){
            Future future = poolExecutor.submit(myThread02);
            String s = (String) future.get();
            System.out.println(s);
        }

        poolExecutor.shutdown();
        System.out.println("主线程停止");
    }
}
