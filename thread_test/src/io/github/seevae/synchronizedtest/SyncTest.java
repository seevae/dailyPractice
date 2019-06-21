package io.github.seevae.synchronizedtest;/*
    name zhang;
    */

/**
 * 以下这种情况还是不能实现互斥访问
 * 原因: 当给方法上锁时,默认的锁对象为this.即当前类的对象
 *   所以每当创建了一个新的线程并执行run方法时,就会产生一个Sync对象sync1,然后这个对象去调用test方法,此时上的锁的对象就是sync1
 *   而当下一个线程进行了同样的操作,调用test方法时锁的对象又变为了sync2.所以出现了线程同时访问的情况(也就是说此时程序中其实有三把锁)
 *   修改:
 *      方法一: 把Sync sync = new Sync() 移到外面
 *      方法二: 给方法加上static
 *
 */
class Sync{
    //改法二
    //加上static后锁的是当前类的反射对象(全局唯一),和方法一改法效果一样
    public static synchronized void test() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"正在打印...");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+"执行结束...");
    }

    //如果在加一个方法,仍然是不可以访问的. 因为整个类只有一把锁.而锁现在在test.
    public synchronized void test2(){ }

}

class Task implements Runnable{
    // 改法一
    // Sync sync = new Sync();
    @Override
    public void run() {
        Sync sync = new Sync();
        try {
            sync.test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SyncTest {
    public static void main(String[] args) {
        Task task = new Task();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
