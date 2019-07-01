package io.github.seevae.threadLocalTest;/*
    name zhang;
    */

public class Test {

    private static String commStr;
    private static ThreadLocal<String> threadLocalStr = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        commStr = " mian - str ";
        threadLocalStr.set("main-ThreadLocal");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                commStr = "thread0-commStr";
                threadLocalStr.set("thread0-ThreadLoaclStr");
            }
        });
        thread.start();
        //主线程等thread执行完后才执行
        thread.join();
        System.out.println(commStr);
        System.out.println(threadLocalStr.get());
    }
}
