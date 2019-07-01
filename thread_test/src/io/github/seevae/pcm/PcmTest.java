package io.github.seevae.pcm;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产者消费者模型
 *
 * 设计模式: 先找到第三方
 * eg: 工厂模式  --> 第三方 工厂
 *     代理模式  --> 第三方 模板
 *
 * 生产者消费者之间有一个第三方
 *
 */

class Goods{
    private String goodsName;
    private int count;
    private int maxCount;

    public Goods(int maxCount) {
        this.maxCount = maxCount;
    }

    public synchronized void set(String goodsName){
        while(count == 1){
            System.out.println(" 此时还有商品,需要等待消费者消费了再继续生产");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.goodsName = goodsName;
        count++;
        System.out.println(Thread.currentThread().getName()+"生产"+this);
        this.notifyAll(); //唤醒消费者线程
    }

    public synchronized void get() {
        while(count == 0){
            System.out.println("此时商品卖完了,需要等待卖家上架");
            //需要让消费者阻塞  this: 指的是当前对象  哪一个对象访问的这个类,就是指的是哪一个对象,例如此时某一个消费者访问这个类
            //所以指的就是当前的这个消费者, this不是指Goods类的对象
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName()+"消费"+this);
        this.notifyAll(); //唤醒生产者线程
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsName='" + goodsName + '\'' +
                ", count=" + count +
                '}';
    }
}

class Producer implements Runnable{

    private Goods goods;

    public Producer(Goods goods){
        this.goods = goods;
    }

    @Override
    public void run() {
        while(true){
            this.goods.set("一个小黑瓶");
        }
    }
}

class Consumer implements Runnable{

    private Goods goods;

    public Consumer(Goods goods){
        this.goods = goods;
    }

    @Override
    public void run() {
            while(true){
                this.goods.get();
            }
    }

}

public class PcmTest {
    public static void main(String[] args) throws InterruptedException {
        Goods goods = new Goods(10);
        Producer producer = new Producer(goods);
        Consumer consumer = new Consumer(goods);
        //产生20个生产者
        List<Thread> list = new ArrayList<>();
        for(int i=0;i<20;i++){
            list.add(new Thread(producer,"生产者"+(i+1)));
        }

        //生产30个消费者
        for(int i=0;i<30;i++){
            list.add(new Thread(consumer,"消费者"+(i+1)));
        }

        //启动所有的生产者消费者
        for(Thread thread:list){
            thread.start();
        }

    }
}
